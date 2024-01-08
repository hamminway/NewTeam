package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "location")
@Getter @Setter @ToString
public class Location {

    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //가게코드

    @Column(nullable = false, length = 100) //공백 불가 100글자까지 지정
    private String locationName;    //장소명

    @Column(name = "price", nullable = false)
    private int price;  //음식가격, 숙소가격, 문화 가격

    @Column(name = "store_address", nullable = false)
    private String address; //주소

    @Column(name = "store_phoneNumber", nullable = false)
    private String phoneNumber;    //연락처

    @Column(name = "store_runTime")
    private String openingTime;  //영업시간

//    private int checkNum;   //조회수
//
//    private int saveNum;    //저장수

    @Lob
    @Column(nullable = false)
    private String locationDetail;  //장소 설명

//    @Enumerated(EnumType.STRING)

    private LocalDateTime regTime;  //등록 시간

    private LocalDateTime updateTime;   //가게 오픈일

}
