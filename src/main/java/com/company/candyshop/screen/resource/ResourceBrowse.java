package com.company.candyshop.screen.resource;

import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Resource;

@UiController("Resource_.browse")
@UiDescriptor("resource-browse.xml")
@LookupComponent("resourcesTable")
public class ResourceBrowse extends StandardLookup<Resource> {
}