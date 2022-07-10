package com.company.candyshop.screen.order;

import com.company.candyshop.app.OrderService;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;

@UiController("Order_.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {
    private static final Logger log = LoggerFactory.getLogger(OrderEdit.class);
    @Autowired
    private TextField<@NotNull Long> orderNumberField;
    @Autowired
    private OrderService orderService;
    @Subscribe
    public void onInitEntity(InitEntityEvent<Order> event) {
        log.warn("index = "+orderService.getNewOrderNumber());
        event.getEntity().setOrderNumber(orderService.getNewOrderNumber());
    }
}