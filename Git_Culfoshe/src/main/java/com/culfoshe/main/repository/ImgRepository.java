package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<IndividualPhoto, Long> {

}
