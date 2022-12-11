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
import com.gcu.business.SecurityBusinessService;
import com.gcu.data.OrderDataService;
import com.gcu.model.LoginModel;
import com.gcu.model.OrderModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/productAdd")
public class ProductController {
	
	@Autowired
	private OrdersBusinessServiceInterface service;
	
	@Autowired
	private OrderDataService data;
	

	
	@GetMapping("/")
    public ModelAndView display(){
        ModelAndView modelAndView = new ModelAndView();
        OrderModel orderModel = new OrderModel();
        modelAndView.addObject("title", "Add Product Page");
        modelAndView.addObject("orderModel", orderModel);
        modelAndView.setViewName("addProduct");
        return modelAndView;
    }
	
	@PostMapping("/productAdd")
    public String register(@Valid OrderModel orderModel, BindingResult bindingResult, Model model){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addProduct");
		if(bindingResult.hasErrors()){
            
            mv.addObject("title", "New Product Form");
            return "productAdd";
        }
		
		if(data.create(orderModel)){
			model.addAttribute("title", "My Products");
	        model.addAttribute("orders", service.getOrders());
            return "orders";
        }else {
            return "home";
        }
        
		
    }
	
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
