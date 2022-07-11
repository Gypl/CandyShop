package com.company.candyshop.screen.order;

import com.company.candyshop.app.OrderService;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.component.Collapsable;
import io.jmix.ui.component.Component;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Order_.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {
    private static final Logger log = LoggerFactory.getLogger(OrderEdit.class);
    @Autowired
    private OrderService orderService;
    @Autowired
    private Notifications notifications;
    @Subscribe
    public void onInitEntity(InitEntityEvent<Order> event) {
        log.warn("index = " + orderService.getNewOrderNumber());
        event.getEntity().setOrderNumber(orderService.getNewOrderNumber());
        if (event.getEntity().getServeReady() == null)
            event.getEntity().setServeReady(false);
    }
    @Subscribe("serveCheck")
    public void onServeCheck(Action.ActionPerformedEvent event) {
        Order order = getEditedEntity();
        log.warn("have conectionery = " + orderService.checkHaveConfectioneries(order));
        if (orderService.checkHaveConfectioneries(order) && (!order.getServeReady())) {
            orderService.consumeConfectioneries(order);
            order.setServeReady(true);
            Component a = event.getComponent();
        } else notifications.create().withCaption("Order already served")
                .withType(Notifications.NotificationType.HUMANIZED)
                .show();
    }

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Order order = getEditedEntity();
        log.warn("have resourses = " + orderService.checkHaveResources(order));
        order.setStartReady(orderService.checkHaveResources(order));
    }
}