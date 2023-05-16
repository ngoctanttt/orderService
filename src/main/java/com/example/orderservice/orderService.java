package com.example.orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    orderRepository orderRepository;

    public void save(orderEntity Order) throws Exception{
        if (Order.getId() == 1){
            throw new Exception("Save error by Id = 1");
        }else
        orderRepository.save(Order);
    }
}
