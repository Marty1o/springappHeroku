package com.gcu.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "orders")
public class OrdersList {
    private List<OrderModel> orders = new ArrayList<OrderModel>();

    @XmlElement(name = "order")
    public List<OrderModel> getOrders() {
        return this.orders;
    }

    public void setOrders(List<OrderModel> orders) {
        this.orders = orders;
    }
}
