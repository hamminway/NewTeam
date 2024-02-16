package com.culfoshe.main.repository;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MainRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MainRepository mainRepository;

    @Test
    @DisplayName("저장 테스트")
    public void createTestList() {
        IndividualPost individualPost = new IndividualPost();

        individualPost.setPostCategory(HeaderCategory.CULTURE);
        individualPost.setPostTitle("테스트 제목");
        individualPost.setPostReview("냐미");

        IndividualPost saved2 = mainRepository.save(individualPost);
        System.out.println(saved2.toString());

    }

    @Test
    @DisplayName("QueryDSL 조회 테스트")
    public void queryDslTest() {

        this.createTestList();
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QPartnerMem qPartnerMem = QPartnerMem.partnerMem;
        QIndividualPost qIndividualPost = QIndividualPost.individualPost;
        QIndividualMem qIndividualMem = QIndividualMem.individualMem;

        JPAQuery<PartnerMem> query1 = queryFactory
                .selectFrom(qPartnerMem)
                .where(qPartnerMem.storeName.like("%" + "테스트 가게 이름" + "%"))
                .orderBy(QPartnerMemPK.partnerMemPK.partnermem_id.desc());

        List<PartnerMem> iMemList = query1.fetch();

        for(PartnerMem partnerMem : iMemList) {
            System.out.println(partnerMem.toString());
        }

        JPAQuery<IndividualPost> query2 = queryFactory
                .selectFrom(qIndividualPost)
                .where(qIndividualPost.postCategory.eq(HeaderCategory.CULTURE))
                .where(qIndividualPost.postTitle.like("%" + "테스트 제목" + "%"))
                .where(qIndividualPost.postReview.like("%" + "테스트 리뷰" + "%"))
                .orderBy(qIndividualPost.postCode.desc());

        List<IndividualPost> postList = query2.fetch();

        for(IndividualPost individualPost : postList) {
            System.out.println(individualPost.toString());
        }

        JPAQuery<IndividualMem> query3 = queryFactory
                .selectFrom(qIndividualMem)
                .where(qIndividualMem.pageName.like("%" + "테스트 페이지 네임" + "%"))
                .where(qIndividualMem.characterName.like("%" + "테스트 닉네임" + "%"))
                .orderBy(qIndividualMem.id.desc());

        List<IndividualMem> pMemList = query3.fetch();

        for(IndividualMem individualMem : pMemList) {
            System.out.println(individualMem.toString());
        }



    }

}