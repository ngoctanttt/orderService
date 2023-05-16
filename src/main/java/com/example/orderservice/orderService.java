package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    orderRepository orderRepository;

    public void save(orderEntity Order){
        orderRepository.save(Order);
    }
}
