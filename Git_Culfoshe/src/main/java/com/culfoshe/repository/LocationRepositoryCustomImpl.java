package com.culfoshe.repository;

import com.culfoshe.dto.MainLocationDTO;
import com.culfoshe.dto.QMainLocationDTO;
import com.culfoshe.entity.QLocation;
import com.culfoshe.entity.QLocationImg;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public class LocationRepositoryCustomImpl implements LocationRepositoryCustom {

    private JPAQueryFactory queryFactory;

    @Override
    public Page<MainLocationDTO> getMainLocationPage(Pageable pageable) {

//        QLocation location = QLocation.location;
//        QLocationImg locationImg = QLocationImg.locationImg;
//
//        QueryResults<MainLocationDTO> results = queryFactory.select(
//                new QMainLocationDTO(
//                        location.id,
//                        location.locationName,
//                        location.locationDetail,
//                        location.checkNum,
//                        location.saveNum,
//                        locationImg.imgUrl
//                )
//
//        )







        return null;
    }
}
