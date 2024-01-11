package com.culfoshe.dto;

import groovy.transform.Sealed;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class LocationDTO {

    private Long id;
    private String title;
    private String locationDetail;
    private int checkNum;
    private int saveNum;
    private LocalDateTime regTime;
}
