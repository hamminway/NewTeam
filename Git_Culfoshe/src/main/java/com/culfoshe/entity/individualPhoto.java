package com.culfoshe.entity;

import javax.persistence.*;

@Entity
public class individualPhoto {

    @Id
    @Column(name = "individual_photo_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long photoCode;

    private String oriImgName;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "post_code")
    private PartnerMem partnerMem;

}
