package com.culfoshe.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class LocationDTO {

    private Long id;

    private String locationName;
    private String representMenu;
    private int price;
    private String address;
    private String phoneNumber;
    private String openingTime;

    private String locationDetail;
    private int reservationPossible;
    private String SellStatusCd;

    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
