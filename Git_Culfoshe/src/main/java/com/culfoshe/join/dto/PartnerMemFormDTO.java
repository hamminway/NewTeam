package com.culfoshe.join.dto;

import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter @ToString
public class PartnerMemFormDTO {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Length(min = 8, max = 20)
    private String password;

    @NotBlank
    private String phoneNum;

    private String storeName;

    @NotBlank
    private String storeNum;

    private String storeLocation;

    private String presidentName;

    @NotBlank
    private String partnerDomain;

    private String specificDetails;

    public static PartnerMem createPartnerMem(PartnerMemFormDTO partnerMemFormDTO, PasswordEncoder passwordEncoder) {

        PartnerMem partnerMem = new PartnerMem();
        PartnerMemPK partnerMemPK = new PartnerMemPK();

        partnerMem.setEmail(partnerMemFormDTO.getEmail());
        String password = passwordEncoder.encode(partnerMemFormDTO.getPassword());
        partnerMem.setPassword(password);

        partnerMem.setName(partnerMemFormDTO.getName());
        partnerMem.setPhoneNum(partnerMemFormDTO.getPhoneNum());

        partnerMem.setStoreName(partnerMemFormDTO.getStoreName());
        partnerMem.setStoreNum(partnerMemFormDTO.getStoreNum());
        partnerMemPK.setStore_location(partnerMemFormDTO.getStoreLocation());
        partnerMem.setPresidentName(partnerMemFormDTO.getPresidentName());

        partnerMem.setPartnerMemPK(partnerMemPK);
        partnerMem.setPartnerDomain(createPartnerDomain(partnerMemFormDTO));
        partnerMem.setSpecificDetails(partnerMemFormDTO.getSpecificDetails());

        return partnerMem;
    }

    public static String createPartnerDomain(PartnerMemFormDTO partnerMemFormDTO){

        return partnerMemFormDTO.getEmail().split("@")[0];

    }
}
