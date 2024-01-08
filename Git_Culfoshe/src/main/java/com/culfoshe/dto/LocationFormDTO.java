package com.culfoshe.dto;

import com.culfoshe.entity.Location;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LocationFormDTO {

    private Long id;

    @NotBlank(message = "상호명은 필수 입력 값입니다.")
    private String locationName;

    private String representMenu;   //대표 메뉴

    @NotBlank(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "주소는 필수 입력 값입니다.")
    private String address;

    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String phoneNumber;

    @NotBlank(message = "영업 시간은 필수 입력 값입니다.")
    private String openingTime;

    @NotBlank(message = "장소 설명은 필수 입력 값입니다.")
    private String locationDetail;

    @NotBlank(message = "예약 가능 여부는 필수 입력 값입니다.")
    private Integer SellStatusCd;

    private List<LocationFormDTO> locationFormDTOS = new ArrayList<>();

    private List<Long> locationImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    //LocationFormDTO를 Location로 매핑하는 메서드
    public Location createLocation() {
        return modelMapper.map(this, Location.class);
    }

    //Location를 LocationFormDTO로 매핑하는 메서드
    public static LocationFormDTO of(Location location) {
        return modelMapper.map(location, LocationFormDTO.class);
    }

}
