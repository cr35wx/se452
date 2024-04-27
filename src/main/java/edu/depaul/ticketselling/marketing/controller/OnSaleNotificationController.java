package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.marketing.command.OnSaleNotificationCommand;

public class OnSaleNotificationController {
    private OnSaleNotificationCommand onSaleNotificationCommand;

    public OnSaleNotificationController(OnSaleNotificationCommand onSaleNotificationCommand) {
        this.onSaleNotificationCommand = onSaleNotificationCommand;
    }

    public void handleOrderConfirmation(String recipient, String eventName) {
        onSaleNotificationCommand.execute(recipient, eventName);
    }
}
