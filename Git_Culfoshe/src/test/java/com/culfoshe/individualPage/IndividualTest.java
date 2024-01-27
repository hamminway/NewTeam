package com.culfoshe.individualPage;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.IndividualPhoto;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.indiviidualPage.repository.IndividualPhotoRepository;
import com.culfoshe.indiviidualPage.repository.IndividualPostCustom;
import com.culfoshe.indiviidualPage.repository.IndividualPostRepository;
import com.culfoshe.indiviidualPage.service.IndividualService;
import com.culfoshe.join.dto.PartnerMemFormDTO;
import com.culfoshe.join.repository.IndividualMemRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
import com.culfoshe.join.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class IndividualTest {
    @PersistenceContext
    EntityManager em;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    MemberService memberService;
    @Autowired
    IndividualService individualService;
    @Autowired
    IndividualPostRepository individualPostRepository;
    @Autowired
    IndividualMemRepository individualMemRepository;

    @Autowired
    IndividualPhotoRepository individualPhotoRepository;

    @Autowired
    IndividualPostCustom individualPostCustom;



    public IndividualMem saving(){
        IndividualMem individualMem = new IndividualMem();
        individualMem.setId((long)0);
        individualMem.setEmail("test@test.com");
        individualMem.setName("testName");
        individualMem.setPhoneNum("2222-1111-1111");
        individualMem.setIndividualDomain("testDomain");
        individualMem.setPassword("1234");
        return individualMem;
    }
    @Test
    @DisplayName("individualTest")
    public void getContent(){

        IndividualMem individualMem = saving();
        IndividualMem savedMem = individualMemRepository.save(individualMem);
        for(int i = 1 ; i < 20 ; i ++){
            IndividualPost individualPost = new IndividualPost();
            individualPost.setPostCode((long)i);
            individualPost.setPostCategory(HeaderCategory.CULTURE);
            individualPost.setMenuCategory("MenuCategory Test");
            individualPost.setPostTitle("Title test");
            individualPost.setLocation("울산광역시 남구 삼산동 업스퀘어");
            individualPost.setIndividualMem(savedMem);
            IndividualPost savedPost = individualPostRepository.save(individualPost);

            for(int j = 0 ; j < 3 ; j++){
                IndividualPhoto individualPhoto = new IndividualPhoto();
                individualPhoto.setPhotoCode((long)i);
                individualPhoto.setOriImgName(i+"oriName"+j);
                individualPhoto.setIndividualPost(savedPost);
                individualPhotoRepository.save(individualPhoto);
            }

        }

        em.flush();
        em.clear();
        Pageable pageable = PageRequest.of(2,5);


//        Page page = individualPostCustom.getIndividualPostPreviewRe(pageable,savedMem.getIndividualDomain());
//        List list = individualPostCustom.getIndividualPostPreviewRe();
//
//        System.err.println("page.getContent : " + page.getContent());
//        System.err.println("page.getContent[0] : " + page.getContent().get(0));

    }
}
