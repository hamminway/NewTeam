package com.culfoshe.partnerPage.service;

import com.culfoshe.join.repository.PartnerMemRepository;
import com.culfoshe.partnerPage.dto.PartnerPageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerMemRepository partnerMemRepository;

    //cotroller 입장에서 이 메서드가 하는 역할: 정보를 가져오는 역할
    public PartnerPageDTO getPartnerPageDTO(){

        /*partnerMemRepository.*/

        return null;
    }

}
