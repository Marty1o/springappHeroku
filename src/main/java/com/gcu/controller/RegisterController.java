package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



import com.gcu.model.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@GetMapping("/")
	public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        UserModel userModel = new UserModel();
        modelAndView.addObject("title", "Register Form");
        modelAndView.addObject("userModel", userModel);
        modelAndView.setViewName("register");
        return modelAndView;
    }
	
	@PostMapping("/register")
    public String register(@Valid UserModel userModel, BindingResult bindingResult, Model model){
		ModelAndView mv = new ModelAndView();
		if(bindingResult.hasErrors()){
            
            mv.addObject("title", "Registration Form");
            return "register";
        }

        
		
		return "registerSuc";
        
		
    }

}
