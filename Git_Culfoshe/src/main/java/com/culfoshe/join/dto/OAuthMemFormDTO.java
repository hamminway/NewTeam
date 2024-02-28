package com.culfoshe.join.dto;

import com.culfoshe.constant.OAuthType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
public class OAuthMemFormDTO {

    private String name;

    @NotBlank
    private String phoneNum;

    private String interest;
    private String interestArea;

    @NotBlank
    private String individualDomain;

    @Enumerated(EnumType.STRING)
    private OAuthType oauth;

/*
    public static IndividualMem createIndividualMem(OAuthMemFormDTO individualMemFormDTO, PasswordEncoder passwordEncoder) {

        IndividualMem individualMem = new IndividualMem();

        individualMem.setEmail(individualMemFormDTO.getEmail());
        String password = passwordEncoder.encode(individualMemFormDTO.getPassword());
        individualMem.setPassword(password);

        individualMem.setName(individualMemFormDTO.getName());
        individualMem.setPhoneNum(individualMemFormDTO.getPhoneNum());

        individualMem.setInterest(individualMemFormDTO.getInterest());
        individualMem.setInterestArea(individualMemFormDTO.getInterestArea());
        individualMem.setIndividualDomain(createIndividualDomain(individualMemFormDTO));
        individualMem.setOauth(OAuthType.CULFOSHE);

        return individualMem;
    }

    public static String createIndividualDomain(OAuthMemFormDTO individualMemFormDTO){

        return individualMemFormDTO.getEmail().split("@")[0];

    }*/
}
