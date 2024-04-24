package com.culfoshe.main.repository;

import com.culfoshe.entity.*;
import com.culfoshe.main.dto.MainDTO;
import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.dto.QMainViewDTO;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class MainRepositoryCustomImpl implements MainRepositoryCustom {

    private JPAQueryFactory queryFactory;

    //생성자를 받아서 초기화
    public MainRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    //검색어가 공백이면 null, 아니면 검색어가 포함되는 상품을 조회
    private BooleanExpression nameByLike(String searchQuery){
        return StringUtils.isEmpty(searchQuery)? null :
                QPartnerMem.partnerMem.storeName.like("%" + searchQuery + "%");
    }

    @Override
    public Page<MainViewDTO> getMainPage(Pageable pageable) {

        System.err.println("main.getMainPage");
        QPartnerMem partnerMem = QPartnerMem.partnerMem;
        QIndividualPost individualPost = QIndividualPost.individualPost;
        QStorePhoto storePhoto = QStorePhoto.storePhoto;

        List<MainViewDTO> content = queryFactory
                .select(new QMainViewDTO(
                        partnerMem.storeName,
                        partnerMem.signatureMenu,
                        partnerMem.storeImage,
                        individualPost.postReview)
                )
                .from(individualPost)
                .join(individualPost.partnerMem, partnerMem)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

      long total = queryFactory.select(Wildcard.count)
              .from(individualPost)
              .join(individualPost.partnerMem, partnerMem)
              .orderBy(partnerMem.storeNum.desc())
              .fetchOne();

        return new PageImpl<>(content, pageable, total);

//        return null;
    }
}
