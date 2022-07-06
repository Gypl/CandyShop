package com.company.candyshop.screen.candyshop;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.CandyShop;

@UiController("CandyShop.edit")
@UiDescriptor("candy-shop-edit.xml")
@EditedEntityContainer("candyShopDc")
public class CandyShopEdit extends StandardEditor<CandyShop> {
}