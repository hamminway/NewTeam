package com.culfoshe.crud;

import com.culfoshe.entity.*;
import com.culfoshe.indiviidualPage.repository.IndividualPhotoRepository;
import com.culfoshe.indiviidualPage.repository.IndividualPostRepository;
import com.culfoshe.join.repository.IndividualMemRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
import com.culfoshe.main.dto.SearchDTO;
import com.culfoshe.main.repository.SearchRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class SearchQuery {
    /*
    *   SearchRepository를 테스트 하려고 한다 (작성한 jpa 메서드가 제대로 동작하는지 검증하기 위해)
    *       1. searchRepository는
    *               a. PartnerMem(가게), IndividualPost(자연적으로 IndividualMem또한) 의 테이블에서 데이터를 가져온다
    *               b. 즉 위 3개의 데이터들의 저장이 선행 되어야 한다.
    *       2. 그럼 Test의 구성은
    *               a. PartnerMem, IndividualMem, IndividualPost 의 데이터들을 임의로 설정하여 저장한다.
    *               b. 저장된 위 데이터들을 searchRepository가 읽어올 수 있는지 테스트 코드를 짠다.
    *
    *       ps.individualPhoto 또한 저장 되어야함
    * */
    @Autowired
    private SearchRepository searchRepository; // 테스트할 repository
    @Autowired
    private PartnerMemRepository partnerMemRepository; //PartnerMem을 저장하기 위한 repository
    @Autowired
    private IndividualMemRepository individualMemRepository; //IndividualMem을 저장하기위한 repository
    @Autowired
    private IndividualPostRepository individualPostRepository; //IndividualPost를 저장하기 위한 repository
    @Autowired
    private IndividualPhotoRepository individualPhotoRepository; // IndividualPhoto를 저장하기 위한 repository


    @Transactional
    //개인 회원을 저장하는 메서드
    public IndividualMem saveIndividualMem(int i){ // 개인회원의 email값을 다르게 하기 위한 변수를 받는역할
        IndividualMem individualMem = new IndividualMem();

        individualMem.setEmail("I" + i);
        individualMem.setPassword("1234" + i);
        individualMem.setPageName("pageName" + i);
        individualMem.setCharacterName("characterName" + i);

        individualMem.setIntroduction(i + "번쩨 멤버"); // 추후 유니크 값으로 사용
        IndividualMem savedMember = individualMemRepository.save(individualMem);
        saveIndividualPost(savedMember, 2);
        System.err.println(saveIndividualPost(savedMember,2));
        return savedMember;
    }

    @Transactional
    //개인 포스트를 저장하는 메서드
    public int saveIndividualPost(IndividualMem individualMem, int j){ //IndividualPost가 참조할 IndividualMem을 매개변수로 넣음
        String unique = individualMem.getIntroduction(); // 추후 사용할 유니크 값
        IndividualPost individualPost = new IndividualPost();

        individualPost.setIndividualMem(individualMem);
        individualPost.setPostTitle(unique + "postTitle" + j); // 추후 다른 값들과 구별하기 위해 individualMem.getEmail넣어주기
        individualPost.setPostReview(unique + "postReview" + j);

        individualPost.setPostReview(unique + j + "번째 글");

        IndividualPost saved = individualPostRepository.save(individualPost);
        System.err.println("2");
        saveIndividualPhoto(saved, 1);

        return j > 0 ? saveIndividualPost(individualMem, j-1) : -1;
    }
    @Transactional
    public int saveIndividualPhoto(IndividualPost individualPost, int k){ //individualPhoto가 참조할 individualPost를 매개변수로

        IndividualPhoto photo = new IndividualPhoto();

        photo.setIndividualPost(individualPost);
        System.err.println("3");
        System.err.println(k);
        individualPhotoRepository.save(photo);

        return k > 0 ? saveIndividualPhoto(individualPost,k-1) : -1;
    }
    @Transactional
    public int savePartnerMem(int i){
        PartnerMem partnerMem = new PartnerMem();
        PartnerMemPK partnerMemPK = new PartnerMemPK();
        partnerMemPK.setStore_location("location" + i);
        partnerMemPK.setPartnermem_id((long)i);
        partnerMem.setPartnerMemPK(partnerMemPK);
        partnerMem.setEmail("partner@test.com" + i);
        partnerMem.setPassword("pass" + i);
        partnerMem.setPresidentName("presidentName" + i);
        partnerMem.setName("name" + i);
        partnerMem.setPhoneNum("phone" + i);
        partnerMem.setStoreName("storeNa" + i);
        partnerMem.setStoreNum("num" + i);
        partnerMem.setSignatureMenu("sig" + i);
        partnerMemRepository.save(partnerMem);
        return i > 0 ? savePartnerMem(i-1) : -1;
    }
    @Test
    public void searchQueryTest(){

//        System.err.println( saveIndividualMem(0));
//        System.err.println();
//
//        IndividualMem individualMem = new IndividualMem();
//        individualMem.setEmail("123");
        System.err.println(saveIndividualMem(saveIndividualPost(saveIndividualMem(9),0)).getIntroduction());


    }

}
