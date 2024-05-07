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
        PartnerMem partnerMem = partnerMemRepository.findByEmail(email);

        LoginSessionDTO loginSessionDTO = null;

        if(individualMem != null){
            individualMem.setPassword(null);

            loginSessionDTO = LoginSessionDTO.transfer(individualMem);
            loginSessionDTO.setIndividualMem(individualMem);

        } else {
            partnerMem.setPassword(null);

            loginSessionDTO = LoginSessionDTO.transfer(partnerMem);

        }

        return loginSessionDTO;
    }

}
