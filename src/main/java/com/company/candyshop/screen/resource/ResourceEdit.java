package com.company.candyshop.screen.resource;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Resource;

@UiController("Resource_.edit")
@UiDescriptor("resource-edit.xml")
@EditedEntityContainer("resourceDc")
public class ResourceEdit extends StandardEditor<Resource> {
}