package com.company.candyshop.screen.order;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Order;

@UiController("Order_.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
public class OrderBrowse extends StandardLookup<Order> {
}