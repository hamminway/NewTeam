package com.culfoshe.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "partnerMem")
@Getter @Setter @ToString
public class PartnerMem{


    @EmbeddedId
    private PartnerMemPK partnerMemPK;

    @Email
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String presidentName;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNum;

    private String storeName;

    @Column(nullable = false)
    private String storeNum;

    private String partnerDomain;

    private String businessHours;

    @Column(nullable = false)
    private String signatureMenu; //이미지
    private String partnerNotice;

    @Column(nullable = false)
    private String storeImage;

}
