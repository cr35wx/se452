package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.marketing.command.OrderConfirmationCommand;

public class OrderConfirmationController {
    private OrderConfirmationCommand orderConfirmationCommand;

    public OrderConfirmationController(OrderConfirmationCommand orderConfirmationCommand) {
        this.orderConfirmationCommand = orderConfirmationCommand;
    }

    public void handleOrderConfirmation(String recipient, String eventName) {
        orderConfirmationCommand.execute(recipient, eventName);
    }
}