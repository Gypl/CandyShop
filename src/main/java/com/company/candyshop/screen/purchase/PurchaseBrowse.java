package com.company.candyshop.screen.purchase;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Purchase;

@UiController("Purchase.browse")
@UiDescriptor("purchase-browse.xml")
@LookupComponent("purchasesTable")
public class PurchaseBrowse extends StandardLookup<Purchase> {
}