package com.culfoshe.partnerPage.dto;

import com.culfoshe.entity.StorePhoto;
import com.culfoshe.indiviidualPage.dto.IndividualPostPreviewDTO;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
public class PartnerPageDTO {

    private String storeName;

    private String store_location;

    private String phoneNum;

    private String businessHours;

    private String specificDetails;

    private String partnerNotice;

    private String storeImage;

    private List<StorePhoto> storePhoto;

    private IndividualPostPreviewDTO storeReview;

    @QueryProjection
    public PartnerPageDTO(String storeName, String store_location, String phoneNum, String businessHours, String specificDetails, String partnerNotice, String storeImage){

        this.storeName = storeName;
        this.store_location = store_location;
        this.phoneNum = phoneNum;
        this.businessHours = businessHours;
        this.specificDetails = specificDetails;
        this.partnerNotice = partnerNotice;
        this.storeImage = storeImage;

    }
}
