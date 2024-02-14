package com.culfoshe.indiviidualPage.dto;

import com.culfoshe.entity.IndividualMem;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Getter @Setter @ToString
public class IndividualPageDTO {

    private List<String> individualFolder;
    private List<String> individualCategory;

    private String pageName;
    private String characterName;
    private String introduction;

    private static ModelMapper modelMapper = new ModelMapper();
    public static IndividualPageDTO createIndividualPageDTO(IndividualMem individualMem){
        return modelMapper.map(individualMem, IndividualPageDTO.class);
    }
}
