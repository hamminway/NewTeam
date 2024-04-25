package com.culfoshe.indiviidualPage.service;


import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.indiviidualPage.dto.LoginSessionDTO;
import com.culfoshe.join.repository.IndividualMemRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginSessionService {

    private final IndividualMemRepository individualMemRepository;
    private final PartnerMemRepository partnerMemRepository;

    public LoginSessionDTO getSessionValue(String email){
        IndividualMem individualMem = individualMemRepository.findByEmail(email);
        individualMem.setPassword(null);
        LoginSessionDTO loginSessionDTO = individualMem != null?
                LoginSessionDTO.transfer(individualMem) :
                LoginSessionDTO.transfer(partnerMemRepository.findByEmail(email));
        loginSessionDTO.setIndividualMem(individualMem);
        return loginSessionDTO;
    }

}
