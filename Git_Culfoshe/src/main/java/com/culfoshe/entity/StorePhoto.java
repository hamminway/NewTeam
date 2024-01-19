package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class StorePhoto {

    @Id
    @Column(name = "photo_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long photoCode;

    private String oriImgName;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "partnermem_id")
    private PartnerMem partnerMem;

    private String repImgYn;
}
