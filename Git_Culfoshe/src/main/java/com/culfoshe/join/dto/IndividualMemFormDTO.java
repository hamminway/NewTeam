package com.culfoshe.join.dto;

import com.culfoshe.entity.IndividualMem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@ToString
public class IndividualMemFormDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 8, max = 20)
    private String password;

    @NotBlank
    private String phoneNum;

    private String interest;
    private String interestArea;

    @NotBlank
    private String individualDomain;

    public static IndividualMem createIndividualMem(IndividualMemFormDTO individualMemFormDTO, PasswordEncoder passwordEncoder) {

        IndividualMem individualMem = new IndividualMem();

        individualMem.setEmail(individualMemFormDTO.getEmail());
        String password = passwordEncoder.encode(individualMemFormDTO.getPassword());
        individualMem.setPassword(password);

        individualMem.setName(individualMemFormDTO.getName());
        individualMem.setPhoneNum(individualMemFormDTO.getPhoneNum());

        individualMem.setInterest(individualMemFormDTO.getInterest());
        individualMem.setInterestArea(individualMemFormDTO.getInterestArea());
        individualMem.setIndividualDomain(createIndividualDomain(individualMemFormDTO));

        return individualMem;
    }

    public static String createIndividualDomain(IndividualMemFormDTO individualMemFormDTO){

        return individualMemFormDTO.getEmail().split("@")[0];

    }
}
