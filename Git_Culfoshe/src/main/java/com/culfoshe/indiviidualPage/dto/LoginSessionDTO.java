package com.culfoshe.indiviidualPage.dto;

import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;

@Getter
@Setter
@ToString
public class LoginSessionDTO {

    private String email;
    private String name;
    private String individualDomain;
    private String partnerDomain;

    private static ModelMapper modelMapper = new ModelMapper();

    public static LoginSessionDTO transfer(IndividualMem individualMem){
        LoginSessionDTO loginSessionDTO = modelMapper.map(individualMem, LoginSessionDTO.class);
        loginSessionDTO.setEmail("personalPage/"+loginSessionDTO.getEmail());
        return loginSessionDTO;
    }
    public static LoginSessionDTO transfer(PartnerMem partnerMem){
        return modelMapper.map(partnerMem, LoginSessionDTO.class);
    }


}
