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
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class SearchQuery {

    /*
 *   SearchRepository를 테스트 하려고 한다 (작성한 jpa 메서드가 제대로 동작하는지
 *                                           검증하기 위해)
 *     1. searchRepository는
 *       a. PartnerMem(가게), IndividualPost(자연적으로 IndividualMem또한)
 *          의 테이블에서 데이터를 가져온다
 *       b. 즉 위 3개의 데이터들의 저장이 선행 되어야 한다.
 *     2. 그럼 Test의 구성은
 *       a. PartnerMem, IndividualMem, IndividualPost 의 데이터들을 임의로
 *          설정하여 저장한다.
 *       b. 저장된 위 데이터들을 searchRepository가 읽어올 수 있는지 테스트 코드를
 *           짠다.
 *
 *   ps.individualPhoto 또한 저장 되어야함
 * */

    @Autowired
    private SearchRepository searchRepository;
    @Autowired
    private PartnerMemRepository partnerMemRepository;
    @Autowired
    private IndividualMemRepository individualMemRepository;
    @Autowired
    private IndividualPostRepository individualPostRepository;
    @Autowired
    private IndividualPhotoRepository individualPhotoRepository;


    @Transactional
    public IndividualMem saveIndividualMem(int i) {
        IndividualMem individualMem = new IndividualMem();

        individualMem.setEmail("IndividualEmail@test.com" + i);
        individualMem.setPassword("1234" + i);
        individualMem.setPageName("pageName" + i);
        individualMem.setCharacterName("characterName" + i);

        individualMem.setIntroduction(i + "번째 멤버");
        IndividualMem savedMember = individualMemRepository.save(individualMem);
        saveIndividualPost(savedMember, 2);

        System.err.println(saveIndividualPost(savedMember,2));
        return savedMember;
    }

    @Transactional
    public int saveIndividualPost(IndividualMem individualMem, int j) {
        String unique = individualMem.getIntroduction(); // 위에 saveIndividualMem에 i번쨰 멤버와 이어짐
        IndividualPost individualPost = new IndividualPost();

        individualPost.setIndividualMem(individualMem);
        individualPost.setPostTitle(unique + "postTitle" + j);
        individualPost.setPostReview(unique + "postReview" + j);

        individualPost.setPostReview(unique + j + "번째 글");

        IndividualPost saved = individualPostRepository.save(individualPost);
        System.err.println("2");
        saveIndividualPhoto(saved, 1);

        return j>0 ? saveIndividualPost(individualMem, j-1) : -1;
    }

    @Transactional
    public int saveIndividualPhoto(IndividualPost individualPost, int k) {

        IndividualPhoto individualPhoto = new IndividualPhoto();

        individualPhoto.setIndividualPost(individualPost);
        System.err.println("3");
        System.err.println(k);
        individualPhotoRepository.save(individualPhoto);

        return k>0 ? saveIndividualPhoto(individualPost, k-1) : -1;
    }

    @Transactional
    public int savePartnerMem(int i) {
        PartnerMem partnerMem = new PartnerMem();
        PartnerMemPK partnerMemPK = new PartnerMemPK();

        partnerMemPK.setStore_location("location" + i);
        partnerMemPK.setPartnermem_id((long) i);
        partnerMem.setPartnerMemPK(partnerMemPK);
        partnerMem.setEmail("partner@test.com");
        partnerMem.setPassword("pass" + i);
        partnerMem.setPresidentName("presidentName" + i);
        partnerMem.setName("name" + i);
        partnerMem.setPhoneNum("phone" + i);
        partnerMem.setStoreName("storeName" + i);
        partnerMem.setStoreNum("num" + i);
        partnerMem.setSignatureMenu("sig" + i);
        partnerMemRepository.save(partnerMem);

        return i>0 ? savePartnerMem(i-1) : -1;
    }

    @Test
    public void searchQueryTest() {
        saveIndividualMem(2);
        savePartnerMem(2);

        Pageable pageable = PageRequest.of(0,6);
        Page page = searchRepository.getSearchPrevPage(new SearchDTO(), pageable);


        System.err.println(saveIndividualMem(0));
        System.err.println();

        IndividualMem individualMem = new IndividualMem();
        individualMem.setEmail("123");

        System.err.println(saveIndividualMem(saveIndividualPost(saveIndividualMem(9),0)).getIntroduction());
    }
}


