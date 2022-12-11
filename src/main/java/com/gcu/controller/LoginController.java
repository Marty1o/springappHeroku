package com.gcu.controller;

//import java.util.ArrayList;
//import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.OrdersBusinessServiceInterface;
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.LoginModel;
//import com.gcu.model.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
    private SecurityBusinessService security;
	
	@GetMapping("/")
    public ModelAndView display(Model model){
        ModelAndView mv = new ModelAndView();
        LoginModel loginModel = new LoginModel();
        mv.addObject("title", "Login Form");
        mv.addObject("loginModel", loginModel);
        mv.setViewName("login");
        return mv; 
	}
	
	@PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model){
        
		if(bindingResult.hasErrors()){
            model.addAttribute("title", "Login Form");
            return "login";
        }

//        ModelAndView mv = new ModelAndView();
//        List<OrderModel> orders = new ArrayList<OrderModel>();
//        orders.add(new OrderModel(0L, "00000001", "Shirt", 1.00f, 1));
//        orders.add(new OrderModel(1L, "00000002", "Toy", 2.00f, 2));
//        orders.add(new OrderModel(2L, "00000003", "Shoes", 3.00f, 3));
//        orders.add(new OrderModel(3L, "00000004", "Desk", 4.00f, 4));
//        orders.add(new OrderModel(4L, "00000005", "Frame", 5.00f, 5));
        
        service.test();
        
        security.authenticate(loginModel.getUsername(), loginModel.getPassword());

        model.addAttribute("title", "My Products");
        model.addAttribute("orders", service.getOrders());
        return "orders";


		
    }

}
