package com.culfoshe.partnerPage.repository;

import com.culfoshe.partnerPage.dto.PartnerPageDTO;

public interface CustomPartnerRepository {

    // 아래를 구현할 구현체(클래스)를 만들어줘야 함.
    public PartnerPageDTO getPartnerPageDTO(String url);


}
