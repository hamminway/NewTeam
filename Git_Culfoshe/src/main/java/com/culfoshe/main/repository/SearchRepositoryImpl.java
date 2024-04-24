package com.culfoshe.main.repository;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.*;
import com.culfoshe.main.dto.QSearchPreviewDTO;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

@Primary
@Repository
public class SearchRepositoryImpl implements SearchRepository {

    private JPAQueryFactory queryFactory;

    //생성자를 받아서 초기화
    public SearchRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    //검색어가 공백이면 null, 아니면 검색어가 포함되는 상품을 조회
    private BooleanExpression searchQueryLike(String searchQuery, StringPath property){
        return StringUtils.isEmpty(searchQuery)? null :
                property.like("%" + searchQuery + "%");
    }

    //headerCategory
    private BooleanExpression searchHeaderCategoryEq(HeaderCategory headerCategory) {
        return headerCategory == null ?
                null : QIndividualPost.individualPost.postCategory.eq(headerCategory);
    }

    private BooleanExpression searchByLikeSearch(String searchBy, String searchQuery, boolean individual) {

        //전체를 보여주게 하는 JAVA 정규표현식
        if(searchQuery.equals("")){
            return null;
        } else if(individual) {
            QIndividualMem individualMem = QIndividualMem.individualMem;
            QIndividualPost individualPost = QIndividualPost.individualPost;
            QPartnerMem partnerMem = QIndividualPost.individualPost.partnerMem;

            if(StringUtils.equals("storeName", searchBy)) {
                return partnerMem.storeName.like("%" + searchQuery + "%");
            } else if(StringUtils.equals("pageName", searchBy)) {
                return individualMem.pageName.like("%" + searchQuery + "%");
            } else if(StringUtils.equals("characterName", searchBy)) {
                System.err.println("characterName");
                System.err.println(searchQuery);
                System.err.println(individualMem.characterName.like("%" + searchQuery + "%"));
                return individualMem.characterName.like("%" + searchQuery + "%");
            } else if(StringUtils.equals("postTitle", searchBy)) {
                return individualPost.postTitle.like("%" + searchQuery + "%");
            }
        } else {
            QPartnerMem partnerMem = QPartnerMem.partnerMem;

            if(StringUtils.equals("storeName", searchBy)) {
                return partnerMem.storeName.like("%" + searchQuery + "%");
            }
        }
        return null;
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery, StringPath element ){

        if(StringUtils.equals("seoul", searchBy)) {
            return element.like("%" + searchQuery + "%");
        }
        return null;
    }


    //현재 시간 이후로 등록된 것을 조회하도록
    //기간으로 검색하는 것이 아니라서 필요없을 거 같기는 함
    private BooleanExpression regDtsAfter(String searchDateType) {
        LocalDateTime dateTime = LocalDateTime.now();

        if (StringUtils.equals("all", searchDateType) || searchDateType == null) {
            return null;
        } else if (StringUtils.equals("1d", searchDateType)) {
            dateTime = dateTime.minusDays(1);
        } else if (StringUtils.equals("1w", searchDateType)) {
            dateTime = dateTime.minusWeeks(1);
        } else if (StringUtils.equals("1m", searchDateType)) {
            dateTime = dateTime.minusMonths(1);
        } else if (StringUtils.equals("6m", searchDateType)) {
            dateTime = dateTime.minusMonths(6);
        }
        return QIndividualPost.individualPost.regTime.after(dateTime);
    }


    //쿼리프로젝션 어노테이션 Q클래스가 만들어준다.
    //쿼리를 생성
    @Override
    public Page<SearchPreviewDTO> getSearchPrevPage(SearchDTO searchDTO, Pageable pageable) {

        System.err.println(searchDTO);
        QPartnerMem partnerMem = QPartnerMem.partnerMem;
        QIndividualPost individualPost = QIndividualPost.individualPost;
        QIndividualPhoto individualPhoto = QIndividualPhoto.individualPhoto;
        QIndividualMem individualMem = QIndividualMem.individualMem;
        QPartnerMemPK partnerMemPK = QPartnerMemPK.partnerMemPK;
        List<SearchPreviewDTO> content = queryFactory
                .select(new QSearchPreviewDTO(
                        individualMem.pageName,
                        individualPost.postTitle,
                        individualMem.characterName,
                        individualPost.postReview,
                        individualPhoto.imgUrl,
                        individualPost.location)
                )
                .from(individualPhoto)
                .join(individualPhoto.individualPost, individualPost)
                .leftJoin(individualPost.individualMem, individualMem)
                .where(searchQueryLike(searchDTO.getSearchQuery(), individualPost.createdBy),
                        regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory())
                        ,searchByLikeSearch(searchDTO.getSearchBy(), searchDTO.getSearchQuery(),true)
                        ,searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery(),individualPost.location))
                .offset(pageable.getOffset())   //데이터를 가지고 올 시작인덱스 지정
                .limit(pageable.getPageSize())  //최대갯수 지정
                .fetch();

        content.addAll(queryFactory
                .select(new QSearchPreviewDTO(
                        partnerMem.storeName,
                        partnerMem.signatureMenu,
                        partnerMem.storeImage,
                        partnerMemPK.store_location)
                )
                .from(partnerMem)
                .where(regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory())
                        ,searchByLikeSearch(searchDTO.getSearchBy(), searchDTO.getSearchQuery(), false)
                        ,searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery(),partnerMemPK.store_location))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch());

        long total = queryFactory.select(Wildcard.count)
                .from(individualPhoto)
                .join(individualPhoto.individualPost, individualPost)
                .join(individualPost.individualMem, individualMem)
                .where(regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory())
//                        ,searchByLikeSearch(searchDTO.getSearchBy(), searchDTO.getSearchQuery())
                        ,searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery(),individualPost.location))
                .fetchOne();

        total += queryFactory.select(Wildcard.count)
                .from(partnerMem)
                .where(regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory())
//                        ,searchByLikeSearch(searchDTO.getSearchBy(), searchDTO.getSearchQuery())
                        ,searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery(),partnerMemPK.store_location))
                .fetchOne();

        return new PageImpl<>(content, pageable, total);

    }
}
