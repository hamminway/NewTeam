package com.culfoshe.join.controller;

import com.culfoshe.entity.PartnerMem;
import com.culfoshe.join.dto.IndividualMemFormDTO;
import com.culfoshe.join.service.MemberService;
import com.culfoshe.join.dto.PartnerMemFormDTO;
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

    @PostMapping(value = "/newIndividual")
    public String individualMemForm(@Valid IndividualMemFormDTO individualMemFormDTO, BindingResult bindingResult, Model model) {

        System.err.println("controller 동작");
        System.err.println("individualMemFormDTO : " + individualMemFormDTO);

        if(bindingResult.hasErrors()){
            return "members/memberForm";
        }

        try {
            memService.saveIndividualMem(individualMemFormDTO);
            System.out.println(individualMemFormDTO.toString());
        } catch (IllegalStateException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "members/memberForm";
        }

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
