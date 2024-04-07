package com.culfoshe.join.controller;

import com.culfoshe.constant.OAuthType;
import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.join.dto.IndividualMemFormDTO;
import com.culfoshe.join.dto.OAuthMemFormDTO;
import com.culfoshe.join.dto.PartnerMemFormDTO;
import com.culfoshe.join.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/login")
    public String loginMember(Principal principal, HttpServletResponse response) throws IOException {

        if(principal != null){
            // 로그인이 되면(Principal 객체가 생성되면) 로그인 화면에 접근이 불가해야하기 때문에
            response.sendError(403, "잘못된 접근입니다.");
            return "index";
        } else {
            // 로그인을 하기 전이면 로그인 화면을 띄워줌.
            return "members/memberLoginForm";
        }
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");

        return "members/memberLoginForm";
    }

    @GetMapping(value = "/new")
    public String individualMemForm(Model model, Principal principal, HttpServletResponse response) throws IOException {

        if(principal != null){
            // 로그인이 되면(Principal 객체가 생성되면) 회원가입 화면에 접근이 불가해야하기 때문에
            response.sendError(403, "잘못된 접근입니다.");
            return "index";

        } else {
            // 로그인을 하기 전이면 회원가입 화면을 띄워줌.
            // 회원가입은 개인, 파트너로 나뉘어져 있으므로 그에 맞게 view에 전달할 객체의 key와 value 값 형식에 맞게 작성함.
            model.addAttribute("individualMemFormDTO", new IndividualMemFormDTO());
            model.addAttribute("partnerMemFormDTO", new PartnerMemFormDTO());

            return "members/memberForm";
        }
    }

    @PostMapping(value = "/newIndividual")
    public String individualMemForm(@Valid IndividualMemFormDTO individualMemFormDTO, BindingResult bindingResult, Model model) {
        // 외부 API를 사용한 회원가입 또한 해당 메서드를 거치고
        // API마다 넘어오는 값들이 상이하다는 점에서 optional을 붙여
        // null으로 넘어오는 데이터 값들을 예외처리하지 않기위해 'optional'을 사용해줌.

        OAuthType oAuthType = null;
        IndividualMem individualSavedMem =  null;

        if(bindingResult.hasErrors()){
            return "index";
        }

        try {
            individualSavedMem = memService.saveIndividualMem(individualMemFormDTO);

            oAuthType = individualSavedMem.getOauth();
            System.out.println(individualMemFormDTO.toString());

        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());

            return "index";
        }

        /*if(oAuthType == OAuthType.KAKAO || oAuthType == OAuthType.GOOGLE){
            // 원래 IndividualMemFormDTO는 회원가입을 진행할 때 넣은 값들로 구성되나
            // google 및 kakao와 같이 외부 API를 이용할 경우에는 값을 외부 API를 통해 받아
            // 위와 같은 상황에 해당되지 않기에 외부 API 값들을 담는 DTO를 만들어줌(넣어줌).
            // 홈페이지를 통한 가입이나 외부 API를 통한 가입 모두 IndividualMem(Entity)에 저장되기에
            // 타입과 필드명이 동일하다는 점에서 ModelMapper의 map 메서드를 이용해줌.
            individualMemFormDTO = IndividualMem.of(individualSavedMem);

            model.addAttribute("individualMemFormDTO", individualMemFormDTO);
            return "members/OAuthAddForm";
        }*/

        return "index";
    }

    @PostMapping(value = "/newIndividual/oauth")
    public String oauthIndividualUpdate(@Valid OAuthMemFormDTO oauthMemFormDTO, @RequestParam String oauthMemberKey){
        // html에서 넘어오는 DTO가 뭐인지도 체크해야함.(model.attribute)
        // RequestParam은 OAuthAddForm.html에서 넘어오는 값. (= oauthMemberKey라는 이름을 가진 값을 찾아서 가져오라는 어노테이션임.)

        if(oauthMemFormDTO.getOauth() == OAuthType.KAKAO) {
            memService.updateKaKaoIndividualMem(oauthMemFormDTO, oauthMemberKey);
            System.err.println("kakao");
        } else if(oauthMemFormDTO.getOauth() == OAuthType.GOOGLE){
            memService.updateGoogleIndividualMem(oauthMemFormDTO, oauthMemberKey);
            System.err.println("google");
        }

        return "index";
    }

    @PostMapping(value = "/newPartner")
    public String partnerMemForm(@Valid PartnerMemFormDTO partnerMemFormDTO, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "members/memberForm";
        }

        try {
            PartnerMem savedPartnerMem = memService.savePartnerMem(partnerMemFormDTO);
            System.err.println("savedPartnerMem : "+ savedPartnerMem);

        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            e.printStackTrace();
            return "members/memberForm";
        }

        return "redirect:/";
    }

    @GetMapping(value = "/checkUser")
    public @ResponseBody ResponseEntity duplicatioEmailCheck(@RequestParam String email){

        boolean flag = memService.validateDulicate(email);

        if(flag){
            return new ResponseEntity("msg", HttpStatus.OK);
        }

        return new ResponseEntity("msg", HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/checkDomain")
    public @ResponseBody ResponseEntity duplicatioDomainCheck(@RequestParam String domain){ //domain은 fetch에서 설정한 이름을 의미함.(내가 설정하는 것임.)

        boolean flag = memService.validateDulicateDomain(domain);

        if(flag){
            return new ResponseEntity("msg", HttpStatus.OK);
        }

       return new ResponseEntity("msg", HttpStatus.ACCEPTED);
    }

    @GetMapping(value="/checkStoreNum")
    public @ResponseBody ResponseEntity duplicatioStoreNumCheck(@RequestParam String storeNum){ //storeNum은 fetch에서 설정한 이름을 의미함.

        boolean flag = memService.validateDulicateStoreNum(storeNum);

        if(flag){
            return new ResponseEntity("msg", HttpStatus.OK);
        }

        return new ResponseEntity("msg", HttpStatus.ACCEPTED);
    }


}
