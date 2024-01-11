package com.culfoshe.entity.members;



import com.culfoshe.dto.members.IndividualMemFormDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "individualMem")
@Getter @Setter @ToString
public class IndividualMem {

    @Id
    @Column(name = "individualMem_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

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
