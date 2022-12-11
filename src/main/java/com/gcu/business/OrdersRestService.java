package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.model.OrderModel;
import com.gcu.model.OrdersList;

@RestController
@RequestMapping("/service")
public class OrdersRestService {
	
	
	@Autowired
    public OrdersBusinessServiceInterface service;

    @GetMapping(path = "/getjson", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<OrderModel> getOrdersAsJson(){
        return service.getOrders();
    }

    @GetMapping(path = "/getxml", produces = {MediaType.APPLICATION_XML_VALUE})
    public OrdersList getOrdersAsXml(){
        OrdersList ordersList = new OrdersList();
        ordersList.setOrders(service.getOrders());
        return ordersList;
    }

}
