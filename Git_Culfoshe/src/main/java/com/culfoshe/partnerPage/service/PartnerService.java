package com.culfoshe.partnerPage.service;

import com.culfoshe.join.repository.PartnerMemRepository;
import com.culfoshe.partnerPage.dto.PartnerPageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerMemRepository partnerMemRepository;

    // cotroller 입장에서 이 메서드가 하는 역할: 정보를 가져오는 역할
    public PartnerPageDTO getPartnerPageDTO(String url){


        return partnerMemRepository.getPartnerPageDTO(url);
    }

    // 컨트롤러에 사용자가 요청(파트너 페이지를 보여달라는 요청)
    // 파트너 멤버의 정보를 데베에서 꺼내옴
    // 얻은 데이터를 토대로 individualPost에서 이 파트너를 참조하고 있는 애들을 다시 뽑아서
    // IndividualPreviewPostDTO에 넣어줌.

}
