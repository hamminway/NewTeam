package com.culfoshe.join.dto;

import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.PartnerMemPK;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter @Setter
public class PartnerMemFormDTO {

    private String name;

    private String email;
    private String password;

    private String phoneNum;

    private String storeName;
    private String storeNum;
    private String storeLocation;

    private String presidentName;

    private String partnerDomain;

    private String businessHours;
    private String signatureMenu; //이미지
    private String partnerNotice;
    private String storeImage;

    public static PartnerMem createPartnerMem(PartnerMemFormDTO partnerMemFormDTO, PasswordEncoder passwordEncoder) {

        PartnerMem partnerMem = new PartnerMem();
        PartnerMemPK partnerMemPK = new PartnerMemPK();
        partnerMemPK.setStore_location(partnerMemFormDTO.getStoreLocation());

        partnerMem.setEmail(partnerMemFormDTO.getEmail());
        String password = passwordEncoder.encode(partnerMemFormDTO.getPassword());
        partnerMem.setPassword(password);

        partnerMem.setName(partnerMemFormDTO.getName());
        partnerMem.setPhoneNum(partnerMemFormDTO.getPhoneNum());

        partnerMem.setStoreName(partnerMemFormDTO.getStoreName());
        partnerMem.setStoreNum(partnerMemFormDTO.getStoreNum());


        partnerMem.setPartnerMemPK(partnerMemPK);

        //값이 어떻게 들어가는지 확일을 위한 메서드
        System.err.println(partnerMem.getPartnerMemPK().getStore_location());
        System.err.println(partnerMem.getPartnerMemPK().getPartnermem_id());

        partnerMem.setPartnerDomain(partnerMemFormDTO.getPartnerDomain());

        return partnerMem;
    }
}
