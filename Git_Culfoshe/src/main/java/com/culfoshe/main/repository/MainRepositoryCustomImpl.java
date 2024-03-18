package com.culfoshe.main.repository;

import com.culfoshe.entity.*;
import com.culfoshe.main.dto.MainDTO;
import com.culfoshe.main.dto.MainViewDTO;
import com.culfoshe.main.dto.QMainViewDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

public class MainRepositoryCustomImpl implements MainRepositoryCustom {

    private JPAQueryFactory queryFactory;

    //생성자를 받아서 초기화
    public MainRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<MainViewDTO> getMainPage(Pageable pageable) {

        QPartnerMem partnerMem = QPartnerMem.partnerMem;
        QIndividualPost individualPost = QIndividualPost.individualPost;
        QStorePhoto storePhoto = QStorePhoto.storePhoto;

        List<MainViewDTO> content = queryFactory
                .select(new QMainViewDTO(
                        partnerMem,
                        individualPost)
                )
                .from(partnerMem)
                .leftJoin(partnerMem).on(individualPost.location.eq(partnerMem.partnerMemPK.store_location))
                .where(storePhoto.repImgYn.eq("Y"))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

      /*long total = queryFactory.select(Wildcard.count)
              .from(partnerMem)*/

        return null;
    }
}
