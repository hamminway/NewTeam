package com.culfoshe.entity;

import javax.persistence.*;

@Entity
public class IndividualPhoto {

    @Id
    @Column(name = "individual_photo_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long photoCode;

    private String oriImgName;

    private String imgName;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "post_code")
    private IndividualPost individualPost;

    public void updateImg(String oriImgName, String imgName, String imgUrl) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}
