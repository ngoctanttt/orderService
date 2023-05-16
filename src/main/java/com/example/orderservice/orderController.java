package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atomikos.icatch.jta.UserTransactionManager;

import org.apache.logging.log4j.*;
import javax.transaction.*;

@RestController
public class orderController {
    @Autowired
    orderService orderService;
    UserTransactionManager utm = new UserTransactionManager();

    private static final Logger log = LogManager.getLogger();
    @PostMapping("/set")
    public orderEntity Save(@RequestBody orderEntity order) throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        utm.begin();
        log.info("Transaction started");
        try {
            orderService.save(order);
            utm.commit();
            log.info("Transaction Commit OrderId "+order.getId());
            return order;
        } catch (Exception e) {
            log.error("Error "+ e);
            utm.rollback();
            log.info("Transaction Rollback OrderId " + order.getId());
        }
        return order;
    }
}

