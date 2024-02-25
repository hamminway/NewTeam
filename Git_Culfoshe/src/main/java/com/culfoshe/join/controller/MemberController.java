package com.culfoshe.join.controller;

import com.culfoshe.constant.OAuthType;
import com.culfoshe.entity.IndividualMem;
import com.culfoshe.entity.PartnerMem;
import com.culfoshe.join.dto.IndividualMemFormDTO;
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

import javax.validation.Valid;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(value = "/login")
    public String loginMember(){
        return "members/memberLoginForm";
    }


    /* @GetMapping(value = "/login/google")
    public String googleAddInform(){
        return "members/googleAddForm";
    }*/


    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요");
        return "members/memberLoginForm";
    }

    @GetMapping(value = "/new")
    public String individualMemForm(Model model) {
        model.addAttribute("individualMemFormDTO", new IndividualMemFormDTO());
        model.addAttribute("partnerMemFormDTO", new PartnerMemFormDTO());

        return "members/memberForm";
    }

    @GetMapping(value = "/login/oauth")
    public String individualMemAddInform(@Valid IndividualMemFormDTO individualMemFormDTO, BindingResult bindingResult, Model model){
        model.addAttribute("individualMemFormDTO", new IndividualMem());

        return "members/OAuthAddForm";
    }

    @PostMapping(value = "/newIndividual")
    public String individualMemForm(@Valid IndividualMemFormDTO individualMemFormDTO, BindingResult bindingResult, Model model) {
        // 외부 API를 사용한 회원가입 또한 해당 메서드를 거치고
        // API마다 넘어오는 값들이 상이하다는 점에서 optional을 붙여
        // null으로 넘어오는 데이터 값들을 예외처리하지 않기위해 'optional'을 사용해줌.

        OAuthType oAuthType = null;
        IndividualMem individualSavedMem =  null;

        if(bindingResult.hasErrors()){
            return "members/memberForm";
        }

        try {
            individualSavedMem = memService.saveIndividualMem(individualMemFormDTO);

            oAuthType = individualSavedMem.getOauth();
            System.out.println(individualMemFormDTO.toString());

        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "members/memberForm";
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

        return "redirect:/";
    }

    @PostMapping(value = "/newPartner")
    public String partnerMemForm(@Valid PartnerMemFormDTO partnerMemFormDTO, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "members/memberForm";
        }

        try {
            PartnerMem savedPartnerMem = memService.savePartnerMem(partnerMemFormDTO);
            System.err.println("savedPartnerMem : "+ savedPartnerMem);
            System.out.println("테스"+partnerMemFormDTO.toString());
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
