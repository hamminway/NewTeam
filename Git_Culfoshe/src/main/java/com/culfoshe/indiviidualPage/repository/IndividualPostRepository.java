package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.entity.IndividualPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndividualPostRepository extends JpaRepository<IndividualPost,Long>, IndividualPostCustom {

    @Query("select i from IndividualPost i where i.individualMem.individualDomain =:domain order by i.regTime desc")
    List<IndividualPost> findIndividualPost(@Param("domain") String domain, Pageable pageable);

    @Query("select count(i) from IndividualPost i where i.individualMem.email = :email")
    Long countPost(@Param("email") String email);


}
