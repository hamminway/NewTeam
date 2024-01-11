package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "location_img")
@Getter @Setter
public class LocationImg extends BaseEntity {

    @Id
    @Column(name = "location_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //기본키
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;    //대표이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    //이미지를 넣는 메서드
    public void updateItemImg(String oriImgName, String imgName, String imgUrl) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;

    }
}
