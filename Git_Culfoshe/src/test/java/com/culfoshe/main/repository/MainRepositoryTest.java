package com.culfoshe.main.repository;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.IndividualPost;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class MainRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired @Qualifier("")
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

}