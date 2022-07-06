package com.company.candyshop.screen.orderedconfectionery;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.OrderedConfectionery;

@UiController("OrderedConfectionery.browse")
@UiDescriptor("ordered-confectionery-browse.xml")
@LookupComponent("orderedConfectioneriesTable")
public class OrderedConfectioneryBrowse extends StandardLookup<OrderedConfectionery> {
}