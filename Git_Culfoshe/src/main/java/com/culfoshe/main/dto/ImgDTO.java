package com.culfoshe.main.dto;

import com.culfoshe.entity.IndividualPhoto;
import com.culfoshe.entity.MenuPhoto;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.entity.StorePhoto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;

@Getter @Setter
public class ImgDTO {

    private Long id;
    private String imgName;
    private String oriImgName;
    private String imgUrl;
    private String repImgYn;

    private static ModelMapper modelMapper = new ModelMapper();

    public static ImgDTO of(PartnerMem partnerMem) {
        return modelMapper.map(partnerMem, ImgDTO.class);
    }

}
