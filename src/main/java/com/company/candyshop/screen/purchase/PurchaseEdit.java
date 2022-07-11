package com.company.candyshop.screen.purchase;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Purchase;

@UiController("Purchase.edit")
@UiDescriptor("purchase-edit.xml")
@EditedEntityContainer("purchaseDc")
public class PurchaseEdit extends StandardEditor<Purchase> {
}