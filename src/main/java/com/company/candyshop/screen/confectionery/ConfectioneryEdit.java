package com.company.candyshop.screen.confectionery;

import com.company.candyshop.app.ConfectioneryService;
import com.company.candyshop.app.OrderService;
import com.company.candyshop.entity.FlowSheet;
import com.company.candyshop.screen.order.OrderEdit;
import io.jmix.core.Messages;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import com.company.candyshop.entity.Confectionery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Confectionery.edit")
@UiDescriptor("confectionery-edit.xml")
@EditedEntityContainer("confectioneryDc")
public class ConfectioneryEdit extends StandardEditor<Confectionery> {

    private static final Logger log = LoggerFactory.getLogger(OrderEdit.class);
    @Autowired
    private ConfectioneryService confectioneryService;
    @Autowired
    private Notifications notifications;

    @Subscribe("confecrioneryNameField")
    public void onConfecrioneryNameFieldValueChange(HasValue.ValueChangeEvent<FlowSheet> event) {
        if (getEditedEntity().getConfectioneryName().getCandyShop() != null)
            getEditedEntity().setCandyShop(getEditedEntity().getConfectioneryName().getCandyShop());
    }
    @Autowired
    private Messages messages;
    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if (!confectioneryService.consumeResources(getEditedEntity())) {
            notifications.create().withCaption(messages.getMessage(("localization/denyConfectionery")))
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
            event.preventCommit();
        }
    }
}