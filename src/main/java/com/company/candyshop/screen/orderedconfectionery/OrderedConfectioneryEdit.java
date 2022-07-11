package com.company.candyshop.screen.orderedconfectionery;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.OrderedConfectionery;

@UiController("OrderedConfectionery.edit")
@UiDescriptor("ordered-confectionery-edit.xml")
@EditedEntityContainer("orderedConfectioneryDc")
public class OrderedConfectioneryEdit extends StandardEditor<OrderedConfectionery> {
}