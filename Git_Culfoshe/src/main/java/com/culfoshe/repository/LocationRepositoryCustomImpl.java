package com.culfoshe.repository;

import com.culfoshe.dto.MainViewDTO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public class LocationRepositoryCustomImpl implements LocationRepositoryCustom {

    private JPAQueryFactory queryFactory;

    @Override
    public Page<MainViewDTO> getMainLocationPage(Pageable pageable) {

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
