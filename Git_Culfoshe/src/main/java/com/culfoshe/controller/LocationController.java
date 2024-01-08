package com.culfoshe.controller;


import com.culfoshe.dto.LocationFormDTO;
import com.culfoshe.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor    //생성자를 자동으로 만들어주는 어노테이션 설정
public class LocationController {

    private final LocationService locationService;

    //게시글 폼으로 보여주기 위한 메서드
    @GetMapping(value = "/admin/location/new")
    public String locationForm(Model model) {
        //model를 담아주기만 하면 알아서 request, response을 사용하고 화면에 담음
        model.addAttribute("locationFormDTO", new LocationFormDTO());
        return "location/locationForm";
    }

    @PostMapping(value = "/admin/location/new")
    //BindingResult : 유효성 검사의 결과를 저장함
    public String locationNew(@Valid LocationFormDTO locationFormDTO,
                              BindingResult bindingResult, Model model,
                              @RequestParam("locationImgFile") List<MultipartFile> locationImgFileList) {

        if(bindingResult.hasErrors()) {
            return "location/locationForm";
        }

        if(locationImgFileList.get(0).isEmpty() && locationFormDTO.getId() == null) {
            model.addAttribute("errorMessage", "첫번째 이미지는 필수입니다.");
            return "location/locationForm";
        }

        try{
            locationService.saveLocation(locationFormDTO, locationImgFileList);
        } catch (Exception e) {
           model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
           return "location/locationForm";
        }

        return "redirect:/";
    }
}

