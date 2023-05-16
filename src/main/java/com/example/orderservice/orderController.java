package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {
    @Autowired
    orderService orderService;

    @PostMapping("/set")
    public orderEntity Save(@RequestBody orderEntity order){
        orderService.save(order);
        return order;
    }
}
