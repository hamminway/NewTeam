package com.culfoshe.indiviidualPage.dto;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class LoginSessionDTO implements Serializable {
    // Serializable를 넣어 밖으로도 값을 가져가 사용할 수 있게함.(없으면 session을 넘길 수 없음)

    private String email;
    private String name;
    private String individualDomain;
    private String partnerDomain;
    private IndividualMem individualMem;

    private static ModelMapper modelMapper = new ModelMapper();

    public static LoginSessionDTO transfer(IndividualMem individualMem){
        LoginSessionDTO loginSessionDTO = modelMapper.map(individualMem, LoginSessionDTO.class);
        loginSessionDTO.setIndividualDomain("personalPage/" + loginSessionDTO.getIndividualDomain());

        return loginSessionDTO;
    }
    public static LoginSessionDTO transfer(PartnerMem partnerMem){
        LoginSessionDTO loginSessionDTO = modelMapper.map(partnerMem, LoginSessionDTO.class);
        loginSessionDTO.setPartnerDomain("partnerPage/" + loginSessionDTO.getPartnerDomain());

        return loginSessionDTO;
    }


}
