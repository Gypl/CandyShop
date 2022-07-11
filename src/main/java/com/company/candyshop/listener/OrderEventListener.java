package com.company.candyshop.listener;

import com.company.candyshop.entity.Order;
import io.jmix.core.event.EntityChangedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @EventListener
    public void onOrderChangedBeforeCommit(EntityChangedEvent<Order> event) {

    }
}