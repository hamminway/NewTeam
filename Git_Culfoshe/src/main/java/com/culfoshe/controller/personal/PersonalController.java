package com.culfoshe.controller.personal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/page")
public class PersonalController {

    @RequestMapping(value = "/newLocation")
    public String newLocation (Model model){

        model.addAttribute()
        return "personalPage/newLocation";
    }

}
