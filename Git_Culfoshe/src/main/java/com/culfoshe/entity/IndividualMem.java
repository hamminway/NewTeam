package com.culfoshe.entity;


import com.culfoshe.constant.OAuthType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "individualMem")
@Getter @Setter @ToString
public class IndividualMem {

    @Id
    @Column(name = "individualmem_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String name;

    private String phoneNum;

    private String interest;
    private String interestArea;

    private String individualDomain;

    private String pageName;
    private String characterName;
    private String introduction;

    private String individualFolder;
    private String individualCategory;
    private int postNum;

    @Enumerated(EnumType.STRING)
    private OAuthType oauth;

}
