package com.culfoshe.main.repository;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.*;
import com.culfoshe.main.dto.QSearchPreviewDTO;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.dto.SearchPreviewDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
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
    private BooleanExpression storeNmLike(String searchQuery){
        return StringUtils.isEmpty(searchQuery)? null :
                QPartnerMem.partnerMem.storeName.like("%" + searchQuery + "%");
    }

    //headerCategory
    private BooleanExpression searchHeaderCategoryEq(HeaderCategory headerCategory) {
        return headerCategory == null ?
                null : QIndividualPost.individualPost.postCategory.eq(headerCategory);
    }

    private BooleanExpression searchByLikeSearch(String searchBy, String searchQuery) {

        QPartnerMem partnerMem = QPartnerMem.partnerMem;
        QIndividualMem individualMem = QIndividualMem.individualMem;
        QIndividualPost individualPost = QIndividualPost.individualPost;

        if(StringUtils.equals("storeName", searchBy)) {
            return partnerMem.storeName.like("%" + searchQuery + "%");
        } else if(StringUtils.equals("pageName", searchBy)) {
            return individualMem.pageName.like("%" + searchQuery + "%");
        } else if(StringUtils.equals("characterName", searchBy)) {
            return individualMem.characterName.like("%" + searchQuery + "%");
        } else if(StringUtils.equals("postTitle", searchBy)) {
            return individualPost.postTitle.like("%" + searchQuery + "%");
        }
        return null;
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){

        QPartnerMemPK partnerMemPK = QPartnerMemPK.partnerMemPK;
        QIndividualPost individualPost = QIndividualPost.individualPost;

        if(StringUtils.equals("seoul", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gyeonggi", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("incheon", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gangwon", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("chungcheong", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("daejeon", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("daegu", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("busan", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("ulsan", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gyeongsang", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gwangju", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("jeonla", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("jeju", searchBy)) {
            return partnerMemPK.store_location.like("%" + searchQuery + "%");
        }

        if(StringUtils.equals("seoul", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gyeonggi", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("incheon", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gangwon", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("chungcheong", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("daejeon", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("daegu", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("busan", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("ulsan", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gyeongsang", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("gwangju", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("jeonla", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
        } else if (StringUtils.equals("jeju", searchBy)) {
            return individualPost.location.like("%" + searchQuery + "%");
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
    public Page<PartnerMem> getPartnerSearchPage(SearchDTO searchDTO, Pageable pageable) {

        List<PartnerMem> content = queryFactory
                .selectFrom(QPartnerMem.partnerMem)
                .where(regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLikeSearch(searchDTO.getSearchBy(), searchDTO.getSearchQuery()))
                .orderBy(QPartnerMemPK.partnerMemPK.partnermem_id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();   //리스트 반환

        content.addAll(queryFactory
                        .select(QPartnerMem.partnerMem)
                        .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                                searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery()))
                        .orderBy(QPartnerMemPK.partnerMemPK.partnermem_id.desc())
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .fetch()
                );

        long total = queryFactory.select(Wildcard.count)
                .from(QPartnerMem.partnerMem)
                .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLike(searchDTO.getSearchBy(),
                                searchDTO.getSearchQuery()))
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<IndividualMem> getIndivMemSearchPage(SearchDTO searchDTO, Pageable pageable) {

        List<IndividualMem> content = queryFactory
                .selectFrom(QIndividualMem.individualMem)
                .where(regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLikeSearch(searchDTO.getSearchBy(), searchDTO.getSearchQuery()))
                .orderBy(QIndividualMem.individualMem.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        content.addAll(queryFactory
                .select(QIndividualMem.individualMem)
                .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery()))
                .orderBy(QIndividualMem.individualMem.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch());

        long total = queryFactory.select(Wildcard.count)
                .from(QIndividualMem.individualMem)
                .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLike(searchDTO.getSearchBy(),
                                searchDTO.getSearchQuery()))
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<IndividualPost> getIndivPostSearchPage(SearchDTO searchDTO, Pageable pageable) {

        List<IndividualPost> content = queryFactory
                .selectFrom(QIndividualPost.individualPost)
                .where(regDtsAfter(searchDTO.getSearchDateType()),
                        searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLikeSearch(searchDTO.getSearchBy(),
                                searchDTO.getSearchQuery()))
                .orderBy(QIndividualPost.individualPost.postCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        content.addAll(queryFactory
                .select(QIndividualPost.individualPost)
                .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLike(searchDTO.getSearchBy(), searchDTO.getSearchQuery()))
                .orderBy(QIndividualPost.individualPost.postCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch());

        long total = queryFactory.select(Wildcard.count)
                .from(QIndividualPost.individualPost)
                .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()),
                        searchByLike(searchDTO.getSearchBy(),
                                searchDTO.getSearchQuery()))
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }


//    @Override
//    public Page<SearchPreviewDTO> getSearchPrevPage(SearchDTO searchDTO, Pageable pageable) {
//
//        QPartnerMem partnerMem = QPartnerMem.partnerMem;
//        QIndividualPost individualPost = QIndividualPost.individualPost;
//        QIndividualPhoto individualPhoto = QIndividualPhoto.individualPhoto;
//
//        List<SearchPreviewDTO> content = queryFactory
//                .select(new QSearchPreviewDTO(
//                        partnerMem.partnerMemPK.partnermem_id,
//                        partnerMem.storeName,
//                        individualPost.postTitle,
//                        individualPost.postReview,
//                        individualPhoto.imgUrl,
//                        individualPost.individualMem.pageName,
//                        individualPost.individualMem.characterName)
//                )
//                .from(individualPhoto)
//                .join(individualPhoto.individualPost, individualPost)
//                .leftJoin(partnerMem).on(individualPost.location.eq(partnerMem.partnerMemPK.store_location))
////                .where(storePhoto.repImgYn.eq("Y"))   //대표 이미지
//                .offset(pageable.getOffset())   //데이터를 가지고 올 시작인덱스 지정
//                .limit(pageable.getPageSize())  //최대갯수 지정
//                .fetch();
//
//        content.addAll(queryFactory
//                .select(new QSearchPreviewDTO(
//                        partnerMem.partnerMemPK.partnermem_id,
//                        partnerMem.storeName,
//                        individualPost.postTitle,
//                        individualPost.postReview,
//                        individualPhoto.imgUrl,
//                        individualPost.individualMem.pageName,
//                        individualPost.individualMem.characterName)
//                )
//                .from(individualPhoto)
//                .join(individualPhoto.individualPost, individualPost)
//                .leftJoin(partnerMem).on(individualPost.location.eq(partnerMem.partnerMemPK.store_location))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch());
//
//        long total = queryFactory.select(Wildcard.count)
//                .from(individualPhoto)
//                .join(individualPhoto.individualPost, individualPost)
//                .leftJoin(partnerMem).on(individualPost.location.eq(partnerMem.partnerMemPK.store_location))
//                .where(searchHeaderCategoryEq(searchDTO.getHeaderCategory()
//                ), searchByLike(searchDTO.getSearchBy(),
//                                searchDTO.getSearchQuery()))
//                .fetchOne();
//
//
//        return new PageImpl<>(content, pageable, total);
//    }
@Override
public Page<SearchPreviewDTO> getSearchPrevPage(SearchDTO searchDTO, Pageable pageable) {

    QPartnerMem partnerMem = QPartnerMem.partnerMem;
    QIndividualPost individualPost = QIndividualPost.individualPost;
    QIndividualPhoto individualPhoto = QIndividualPhoto.individualPhoto;
    QIndividualMem individualMem = QIndividualMem.individualMem;
    QPartnerMemPK partnerMemPK = QPartnerMemPK.partnerMemPK;

    List<SearchPreviewDTO> content = queryFactory
            .select(new QSearchPreviewDTO(
                    individualPost.postTitle,
                    individualMem.characterName,
                    individualPost.postReview,
                    individualPhoto.imgUrl,
                    individualPost.location
            ))
            .from(individualPhoto)
            .join(individualPhoto.individualPost, individualPost)
            .join(individualPost.individualMem, individualMem)
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
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch());

    long total = queryFactory.select(Wildcard.count)
            .from(individualPhoto)
            .join(individualPhoto.individualPost, individualPost)
            .join(individualPost.individualMem, individualMem)
            .fetchOne();

    total += queryFactory.select(Wildcard.count)
            .from(partnerMem)
            .fetchOne();

    return new PageImpl<>(content, pageable, total);

}

}
