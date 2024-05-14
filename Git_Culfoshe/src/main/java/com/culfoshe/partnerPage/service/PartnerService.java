package com.culfoshe.partnerPage.service;

import com.culfoshe.indiviidualPage.repository.IndividualPostRepository;
import com.culfoshe.join.repository.PartnerMemRepository;
import com.culfoshe.partnerPage.dto.PartnerPageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerMemRepository partnerMemRepository;

    private final IndividualPostRepository individualPostRepository;

    // cotroller 입장에서 이 메서드가 하는 역할: 정보를 가져오는 역할
    public PartnerPageDTO getPartnerPageDTO(String url){

        PartnerPageDTO partnerPageDTO = partnerMemRepository.getPartnerPageDTO(url);

        /*
        페이징 처리를 새로고침 없이 RestController를 이용해 구현하고자 함.
        지금 적던 내용들을 다른 메서드에 구현할 거라 주석 처리한 것임.

        partnerPageDTO.setStorePhoto();
        partnerPageDTO.setStoreReview(individualPostRepository.getIndividualPostPreviewForPartnerMem());
        */

        return null;
    }

    // 컨트롤러에 사용자가 요청(파트너 페이지를 보여달라는 요청)
    // 파트너 멤버의 정보를 데베에서 꺼내옴
    // 얻은 데이터를 토대로 individualPost에서 이 파트너를 참조하고 있는 애들을 다시 뽑아서
    // IndividualPreviewPostDTO에 넣어줌.

}
