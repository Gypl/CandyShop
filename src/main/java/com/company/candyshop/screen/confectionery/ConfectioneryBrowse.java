package com.company.candyshop.screen.confectionery;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Confectionery;

@UiController("Confectionery.browse")
@UiDescriptor("confectionery-browse.xml")
@LookupComponent("confectioneriesTable")
public class ConfectioneryBrowse extends StandardLookup<Confectionery> {
}