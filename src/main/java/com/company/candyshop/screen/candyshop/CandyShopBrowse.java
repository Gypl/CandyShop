package com.company.candyshop.screen.candyshop;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.CandyShop;

@UiController("CandyShop.browse")
@UiDescriptor("candy-shop-browse.xml")
@LookupComponent("candyShopsTable")
public class CandyShopBrowse extends StandardLookup<CandyShop> {
}