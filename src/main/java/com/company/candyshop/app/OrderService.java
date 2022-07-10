package com.company.candyshop.app;

import com.company.candyshop.entity.Order;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private DataManager dataManager;

    public long getNewOrderNumber(){
        long result = 0;

        List<Order> orderList = dataManager.load(Order.class).all().fetchPlan("order-max-number").list();
        if (orderList.size() != 0) {
            for (Order order : orderList) {
                long orderNumber = order.getOrderNumber();
                if (result < orderNumber)
                    result = orderNumber;
            }
        }
        return result + 1;
    }
}