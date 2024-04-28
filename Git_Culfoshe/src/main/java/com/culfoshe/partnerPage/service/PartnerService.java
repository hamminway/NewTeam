package com.culfoshe.partnerPage.service;

import com.culfoshe.join.repository.PartnerMemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerService {

    private final PartnerMemRepository partnerMemRepository;
}
