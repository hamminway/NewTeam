package com.culfoshe.main.dto;

import com.culfoshe.constant.HeaderCategory;
import com.culfoshe.entity.IndividualPost;
import com.culfoshe.entity.PartnerMem;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class MainDTO {

    private Long id;
    private String storeName;
    private String signatureMenu;
    private String postReview;

    private HeaderCategory headerCategory;
    private List<ImgDTO> imgDTOList = new ArrayList<>();
    private List<Long> imgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public PartnerMem partMain() {
        return modelMapper.map(this, PartnerMem.class);
    }

    public IndividualPost IndivMain() {
        return modelMapper.map(this, IndividualPost.class);
    }

    public static MainDTO upMain(PartnerMem partnerMem,
                                  IndividualPost individualPost) {
        MainDTO mainDTO = modelMapper.map(partnerMem, MainDTO.class);
        MainDTO mainDTO2 = modelMapper.map(individualPost, MainDTO.class);
        mainDTO.setPostReview(mainDTO2.getPostReview());

        return mainDTO;
    }


}
