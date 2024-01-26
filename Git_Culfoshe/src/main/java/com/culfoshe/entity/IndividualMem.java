package com.culfoshe.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "individualMem")
@Getter @Setter @ToString
public class IndividualMem {

    @Id
    @Column(name = "individualmem_id")
    private Long id;

    @Email
    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
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


}
