package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessInterface;
import com.gcu.data.OrderDataService;
import com.gcu.model.OrderModel;

public class OrdersBusinessService implements OrdersBusinessServiceInterface {


	@Autowired
    private OrderDataService service;


    public void test() {
        System.out.println("Hello from OrdersBusinessService");
    }

    @Override
    public List<OrderModel> getOrders() {
        System.out.println("Generating a list from getOrders()");
        return service.findAll();

    }
    
    public boolean addProduct(OrderModel orderModel){
        return service.create(orderModel);
     }

    public void init() {
        System.out.println("Hello from OBS init()");
    }

    public void destroy() {
        System.out.println("Hello from OBS destroy()");
    }
    
    public boolean deleteProduct(OrderModel orderModel)
    {
        return service.delete(orderModel);
    }


	

}
