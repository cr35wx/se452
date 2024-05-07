package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

import edu.depaul.ticketselling.marketing.model.*;
import edu.depaul.ticketselling.marketing.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.depaul.ticketselling.marketing.command.OnSaleNotificationCommand;

/**
 * [Marketing and communication]
 * This code is the Controller of On-Sale Notification.
 * 
 * This controller is responsible for sending on-sale notification emails to users.
 * It interacts with the OnSaleNotificationCommand to execute the logic for sending emails.
 * 
 * It retrieves the list of users and events from the marketing database repositories and
 * passes them to the OnSaleNotificationCommand for processing.
 * 
 * Upon successful execution, it returns a message indicating that the on-sale notification emails
 * have been sent successfully.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class OnSaleNotificationController {
    private final OnSaleNotificationCommand onSaleNotificationCommand;
    private final mkAccountRepository accountRepository;
    private final mkEventRepository eventRepository;

    /**
     * Constructor for OnSaleNotificationController.
     * 
     * @param onSaleNotificationCommand The command for sending on-sale notification emails.
     */
    @Autowired
    public OnSaleNotificationController(OnSaleNotificationCommand onSaleNotificationCommand,
                                        mkAccountRepository accountRepository,
                                        mkEventRepository eventRepository) {
        this.onSaleNotificationCommand = onSaleNotificationCommand;
        this.accountRepository = accountRepository;
        this.eventRepository = eventRepository;
    }

    /**
     * Endpoint for sending on-sale notification emails to users.
     * 
     * @return A message indicating that the on-sale notification emails have been sent successfully.
     */
    @GetMapping("/send-on-sale-notification")
    public String sendOnSaleNotificationEmails() {
        List<mkAccount> users = accountRepository.findAll();
        List<mkEvent> events = eventRepository.findAll();
        for (mkAccount user : users) {
            onSaleNotificationCommand.execute(user, events);
        }
        return "On-sale notification emails have been sent successfully.";
    }
}
