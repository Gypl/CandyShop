package com.company.candyshop.screen.confectionery;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Confectionery;

@UiController("Confectionery.edit")
@UiDescriptor("confectionery-edit.xml")
@EditedEntityContainer("confectioneryDc")
public class ConfectioneryEdit extends StandardEditor<Confectionery> {
}