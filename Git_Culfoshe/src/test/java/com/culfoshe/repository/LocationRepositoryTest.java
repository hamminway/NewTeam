package com.culfoshe.repository;


import com.culfoshe.entity.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class LocationRepositoryTest {

    @Autowired
    LocationRepository locationRepository;

    @PersistenceContext
    EntityManager em;

    @Test
    @DisplayName("장소 저장 테스트")
    public void createLocationTest() {
        Location location = new Location();

        location.setLocationName("테스트 장소");
        location.setPrice(1000000);
        location.setAddress("테스트 장소 주소");
        location.setPhoneNumber("010-0000-0000");
        location.setOpeningTime("테스트 영업 시간");
        location.setLocationDetail("테스트 장소 상세 설명");
        location.setRegTime(LocalDateTime.now());
        location.setUpdateTime(LocalDateTime.now());

        Location savedLocation = locationRepository.save(location);
        System.out.println(savedLocation.toString());
    }

    public void createLocationList() {
        for(int i=1; i<=10; i++) {
            Location location = new Location();

            location.setLocationName("테스트 상품" + i);
            location.setPrice(1000000 + i);
            location.setAddress("테스트 장소 주소" + i);
            location.setPhoneNumber("010-0000-0000" + i);
            location.setOpeningTime("테스트 영업 시간" + i);
            location.setLocationDetail("테스트 장소 상세 설명"+ i);
            location.setRegTime(LocalDateTime.now());
            location.setUpdateTime(LocalDateTime.now());

            Location savedLocation = locationRepository.save(location);
        }

    }

    @Test
    @DisplayName("장소명 조회 테스트")
    public void findByLocationNameTest() {
        this.createLocationList();
//      List<Location> LocationList = locationRepository.findByLocationName("테스트 상품1");

        List<Location> locationList = locationRepository
                .findByLocationNameOrLocationDetail("테스트 상품1","테스트 장소 상세 설명5");
            for(Location location : locationList) {
                System.out.println(location.toString());
            }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    public void findByOrderPriceThanTest() {
        this.createLocationList();

        List<Location> locationList = locationRepository.findByPriceLessThan(1000004);
        for(Location location : locationList) {
            System.out.println(location.toString());
        }
    }

    @Test
    @DisplayName("가격 LessThanOrderBy 테스트")
    public void findByPriceLessThanOrderByPriceDescTest() {
        this.createLocationList();

        List<Location> locationList = locationRepository
                        .findByPriceLessThanOrderByPriceDesc(1000004);

        for (Location location : locationList) {
            System.out.println(location.toString());
        }
    }

    @Test
    @DisplayName("@Query")
    public void findByLocationDetailTest() {
        this.createLocationList();

        List<Location> locationList = locationRepository
                .findByLocationDetail("테스트 장소 상세 설명");

        for (Location location : locationList) {
            System.out.println(location.toString());
        }
    }

    @Test
    @DisplayName("nativeQuery를 이용한 상품 조회 리스트")
    public void findByLocationDetailByNativeTest() {
        this.createLocationList();

        List<Location> locationList = locationRepository
                .findByLocationDetailByNative("테스트 장소 상세 설명");

        for (Location location : locationList) {
            System.out.println(location.toString());
        }
    }








}