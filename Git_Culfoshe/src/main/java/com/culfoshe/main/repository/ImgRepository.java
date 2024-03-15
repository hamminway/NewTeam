package com.culfoshe.main.repository;

import com.culfoshe.entity.IndividualPhoto;
import com.culfoshe.entity.StorePhoto;
import org.apache.catalina.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImgRepository extends JpaRepository<StorePhoto, Long> {

}
