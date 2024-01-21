package com.culfoshe.main.repository;

import com.culfoshe.entity.*;
import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.dto.QMainViewDTO;
import com.culfoshe.main.dto.SearchDTO;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

public class MainRepositoryImpl implements MainRepository{

    private JPAQueryFactory queryFactory;

    //생성자를 받아서 초기화
    public MainRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    //검색어가 공백이면 null, 아니면 검색어가 포함되는 상품을 조회
    private BooleanExpression itemNameLike(String searchQuery){
        return StringUtils.isEmpty(searchQuery)? null :
                QPartnerMem.partnerMem.storeName.like("%" + searchQuery + "%");
    }


    @Override
    public Page<MainViewDTO> getMainViewPage(SearchDTO searchDTO, Pageable pageable) {

        QPartnerMem partnerMem = QPartnerMem.partnerMem;
        QIndividualPost individualPost = QIndividualPost.individualPost;
        QIndividualPhoto individualPhoto = QIndividualPhoto.individualPhoto;
//        QStorePhoto storePhoto = QStorePhoto.storePhoto;

        QueryResults<MainViewDTO> results = queryFactory
                .select(new QMainViewDTO(
                        individualPost.PostCode,
                        partnerMem.storeName,
                        individualPost.postReview,
                        individualPhoto.imgUrl)
                )
                .from(individualPhoto)
                .join(individualPhoto.partnerMem, partnerMem)
//                .where(storePhoto.repImgYn.eq("Y"))   //대표 이미지
                .offset(pageable.getOffset())   //데이터를 가지고 올 시작인덱스 지정
                .limit(pageable.getPageSize())  //최대갯수 지정
                .fetchResults();    //






        return null;
    }
}
