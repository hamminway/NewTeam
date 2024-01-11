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
    private String title;    //제목

    @Column(nullable = false, length = 100) //공백 불가 100글자까지 지정
    private String locationName;    //장소명

    @Lob
    @Column(nullable = false)
    private int locationDetail;  //한줄평

    private int checkNum;   //조회수

    private int saveNum;    //저장수

    private LocalDateTime regTime;  //등록 시간

}
