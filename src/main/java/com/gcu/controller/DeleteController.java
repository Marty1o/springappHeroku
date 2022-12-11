package com.gcu.controller;

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
import com.gcu.data.OrderDataService;
import com.gcu.model.OrderModel;
import com.gcu.model.UserModel;



@Controller
@RequestMapping("/deleteProduct")
public class DeleteController {
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private OrderDataService data;
	
	@PostMapping("/deleteProduct")
    public String delete(@Valid OrderModel orderModel, BindingResult bindingResult, Model model){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deleteProduct");
		if(bindingResult.hasErrors()){
            
            mv.addObject("title", "Delete Product Form");
            return "deleteProduct";
        }
		
		if(data.create(orderModel)){
			model.addAttribute("title", "My Products");
	        model.addAttribute("orders", service.getOrders());
            return "orders";
        }else {
            return "home";
        }
        
		
    }

}
