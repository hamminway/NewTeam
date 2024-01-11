package com.culfoshe.dto.members;

import com.culfoshe.entity.members.IndividualMem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;

@Getter @Setter
public class IndividualMemFormDTO {

    private String name;

    @Email
    private String email;
    private String password;

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

    public static IndividualMem createIndividualMem(IndividualMemFormDTO individualMemFormDTO, PasswordEncoder passwordEncoder) {

        IndividualMem individualMem = new IndividualMem();

        individualMem.setEmail(individualMemFormDTO.getEmail());
        String password = passwordEncoder.encode(individualMemFormDTO.getPassword());
        individualMem.setPassword(password);

        individualMem.setName(individualMemFormDTO.getName());
        individualMem.setPhoneNum(individualMemFormDTO.getPhoneNum());

        individualMem.setInterest(individualMemFormDTO.getInterest());
        individualMem.setInterestArea(individualMemFormDTO.getInterestArea());

        return individualMem;
    }
}
