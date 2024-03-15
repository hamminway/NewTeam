package com.culfoshe.main.repository;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.*;
import com.culfoshe.indiviidualPage.repository.IndividualPostRepository;
import com.culfoshe.join.repository.IndividualMemRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
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

    @Autowired
    IndividualMemRepository individualMemRepository;
    @Autowired
    PartnerMemRepository partnerMemRepository;
    @Autowired
    SearchRepository searchRepository;
    @Autowired
    IndividualPostRepository individualPostRepository;

    public IndividualMem saveIndividual(){
        IndividualMem individualMem = new IndividualMem();
        individualMem.setId(Long.valueOf("1111111"));
        individualMem.setEmail("test@test.com");
        individualMem.setPassword("1111");
        individualMem.setName("테스트");
        individualMem.setPhoneNum("010-0000-0000");
        individualMem.setPageName("냐미 페이지");
        individualMem.setCharacterName("냐미냐미");
        return individualMemRepository.save(individualMem);
    }

    public PartnerMem savePartner() {
        PartnerMem partnerMem = new PartnerMem();

        PartnerMemPK partnerMemPK = new PartnerMemPK();
        partnerMemPK.setPartnermem_id(Long.valueOf("222222"));
        partnerMemPK.setStore_location("test_location");

        partnerMem.setPartnerMemPK(partnerMemPK);
        partnerMem.setEmail("partTest@test.com");
        partnerMem.setPassword("2222");
        partnerMem.setPresidentName("파트너테스트");
        partnerMem.setName("파트너");
        partnerMem.setPhoneNum("010-222-3333");
        partnerMem.setStoreName("테스트 가게");
        partnerMem.setStoreNum("000-000-0000");
        return partnerMemRepository.save(partnerMem);
    }

    public IndividualPost saveIndividualPost() {
        IndividualPost individualPost = new IndividualPost();
        individualPost.setPostCode(Long.valueOf("333333"));
        individualPost.setPostCategory(HeaderCategory.CULTURE);
        individualPost.setPostTitle("테스트 제목");
        individualPost.setPostReview("냐미");
        return mainRepository.save(individualPost);
    }


    @Test
    @DisplayName("저장 테스트")
    public void saveTestList() {
        IndividualMem individualMem = saveIndividual();
        PartnerMem partnerMem = savePartner();
        IndividualPost individualPost = saveIndividualPost();

        IndividualMem findIndividual = individualMemRepository.findByEmail(individualMem.getEmail());
        PartnerMem findPartner = partnerMemRepository.findByEmail(partnerMem.getEmail());
        IndividualPost findPost = mainRepository.findByPostCode(individualPost.getPostCode());

        System.out.println(findIndividual);
        System.out.println(findPartner);
        System.out.println(findPost);
    }


    @Test
    @DisplayName("QueryDSL 조회 테스트")
    public void queryDslTest() {

        this.saveTestList();
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