package com.culfoshe.main.service;

import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.StorePhoto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MainService {

    private IndividualPost individualPost;
    private PartnerMem partnerMem;

//    public MainService saveStore(PartnerMem storeName, IndividualPost postReview,
//                                 StorePhoto imgUrl){
//
//    }

}
