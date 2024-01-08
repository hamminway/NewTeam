package com.culfoshe.repository;

import com.culfoshe.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
//    List<Location> findByLocationName(String locationName);
    //장소명 조회 테스트
    List<Location> findByLocationNameOrLocationDetail
                            (String locationName, String locationDetail);

    //가격 LessThan 테스트
    List<Location> findByPriceLessThan(Integer price);

    //가격 LessThanOrderBy 테스트
    List<Location> findByPriceLessThanOrderByPriceDesc(Integer price);

    //@Query
    //@Param 각 변수를 구분할 수 있게 붙여줌
    @Query("select i from Location i where i.locationDetail like %:locationDetail% "
            + " order by i.price desc")
    List<Location> findByLocationDetail(@Param("locationDetail") String locationDetail);

    @Query(value = "select * from Location i where i.location_Detail like %:locationDetail%" +
            " order by i.price desc", nativeQuery = true)
    List<Location> findByLocationDetailByNative(@Param("locationDetail") String locationDetail);
}
