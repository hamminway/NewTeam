package com.culfoshe.indiviidualPage.repository;

import com.culfoshe.entity.IndividualPhoto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndividualPhotoRepository extends JpaRepository<IndividualPhoto, Long> {

    @Query("select i.imgUrl from IndividualPhoto i where i.individualPost.postCode =:postCode")
    List<String> findPhoto(@Param("postCode") Long postCode);


}
