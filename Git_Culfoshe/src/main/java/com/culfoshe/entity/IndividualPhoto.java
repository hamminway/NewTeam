package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter @Setter @ToString @Entity
public class IndividualPhoto {
    @Id
    @Column(name = "individual_photo_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photoCode;

    private String oriImgName;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "post_code")
    private IndividualPost individualPost;
}
