package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/contact")
public class ContactController {
	
	@GetMapping("/")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contact");
        return modelAndView;
    }

}
