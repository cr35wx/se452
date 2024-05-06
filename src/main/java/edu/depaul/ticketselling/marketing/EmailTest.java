package edu.depaul.ticketselling.marketing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.depaul.ticketselling.marketing.controller.EventReminderController;
import edu.depaul.ticketselling.marketing.controller.OnSaleNotificationController;

@Component
public class EmailTest implements CommandLineRunner {

    @Autowired
    private OnSaleNotificationController onSaleNotificationController;

    @Autowired
    private EventReminderController eventReminderController;

    @Override
    public void run(String... args) throws Exception {
        // Only test sendOnSaleNotificationEmails and sendEventReminderEmails.
        // EventChange and OrderConfirm is need management's purchase and event change/cancel.
        onSaleNotificationController.sendOnSaleNotificationEmails();
        eventReminderController.sendEventReminderEmails();
    }
}
