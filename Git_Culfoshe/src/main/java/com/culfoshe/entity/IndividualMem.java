package com.culfoshe.entity;


import com.culfoshe.constant.OAuthType;
import com.culfoshe.join.dto.IndividualMemFormDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Table(name = "individualMem")
@Getter @Setter @ToString
public class IndividualMem {

    @Id
    @Column(name = "individualmem_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public static IndividualMemFormDTO of(IndividualMem individualMem) {

        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(individualMem, IndividualMemFormDTO.class);
    }

}
