package com.company.candyshop.screen.flowsheet;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.FlowSheet;

@UiController("FlowSheet.edit")
@UiDescriptor("flow-sheet-edit.xml")
@EditedEntityContainer("flowSheetDc")
public class FlowSheetEdit extends StandardEditor<FlowSheet> {
}