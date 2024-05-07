package com.culfoshe.partnerPage.repository;

import com.culfoshe.entity.QPartnerMem;
import com.culfoshe.partnerPage.dto.PartnerPageDTO;
import com.culfoshe.partnerPage.dto.QPartnerPageDTO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;

public class CustomPartnerRepositoryImpl implements CustomPartnerRepository{

    private JPAQueryFactory queryFactory;

    //생성자
    public CustomPartnerRepositoryImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    // query문의 조건절을 자동으로 만들어주는 메서드
    private BooleanExpression searchByLike(String url){
        return QPartnerMem.partnerMem.partnerDomain.like("%"+url+"%");
    }

    @Override
    public PartnerPageDTO getPartnerPageDTO(String url) {

        QPartnerMem partnerMem = QPartnerMem.partnerMem;

        PartnerPageDTO partnerPageDTO = queryFactory.select(
                new QPartnerPageDTO(
                        partnerMem.storeName,
                        partnerMem.partnerMemPK.store_location,
                        partnerMem.phoneNum,
                        partnerMem.businessHours,
                        partnerMem.specificDetails,
                        partnerMem.partnerNotice,
                        partnerMem.storeImage
                )
        ).from(partnerMem)
                .where(searchByLike(url))
                .fetchOne();

        System.err.println("content : " + partnerPageDTO);
        return partnerPageDTO;
    }
}
