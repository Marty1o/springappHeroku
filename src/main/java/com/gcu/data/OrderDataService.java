package com.gcu.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.OrderEntity;
import com.gcu.data.repository.OrdersRepository;
import com.gcu.model.OrderModel;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDataService implements DataAccessInterface<OrderModel>{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private OrdersRepository ordersRepository;

    public OrderDataService(OrdersRepository ordersRepository, DataSource dataSource) {
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List findAll() {
        List<OrderEntity> orders = new ArrayList<>();
        try {
            Iterable<OrderEntity> orderEntities = ordersRepository.findAll();
            orderEntities.forEach(orders::add);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderModel findById(int id) {
        return null;
    }

    @Override
    public boolean create(OrderModel order) {
       String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?,?,?,?)";
       try {
           jdbcTemplate.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
       return true;
    }

    @Override
    public boolean update(OrderModel order) {
        return true;
    }

    @Override
    public boolean delete(OrderModel order) {
    	String sql = "DELETE FROM PRODUCT WHERE ORDER_NO = ?";
        try {
            jdbcTemplate.update(sql, order.getOrderNo());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
}