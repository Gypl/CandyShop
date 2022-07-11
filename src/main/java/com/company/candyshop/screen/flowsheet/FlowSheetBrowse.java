package com.company.candyshop.screen.flowsheet;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.FlowSheet;

@UiController("FlowSheet.browse")
@UiDescriptor("flow-sheet-browse.xml")
@LookupComponent("flowSheetsTable")
public class FlowSheetBrowse extends StandardLookup<FlowSheet> {
}