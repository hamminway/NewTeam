package com.culfoshe.entity;

import javax.persistence.*;

@Entity
public class MenuPhoto {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuCode;

    private String oriImgName;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "partnermem_id")
    private PartnerMem partnerMem;

}
