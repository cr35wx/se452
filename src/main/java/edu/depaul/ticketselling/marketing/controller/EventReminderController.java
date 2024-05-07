package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.marketing.model.mkAccount;
import edu.depaul.ticketselling.marketing.model.mkTicket;
import edu.depaul.ticketselling.marketing.service.mkAccountService;
import edu.depaul.ticketselling.marketing.service.mkTicketService;

import edu.depaul.ticketselling.marketing.command.EventReminderCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * [Marketing and communication]
 * This code is the Controller of Event Reminder.
 *
 * This controller handles sending event reminder emails to purchasers.
 * It interacts with the EventReminderCommand to execute the logic for sending event reminder emails.
 *
 * Upon receiving a request to send event reminders, it retrieves all tickets with associated accounts
 * and sends reminder emails to the corresponding email addresses.
 *
 * @author [Your Name]
 */
@RestController
@RequestMapping("/email")
@Component
public class EventReminderController {
    private final EventReminderCommand eventReminderCommand;
    private final mkTicketService ticketService;
    private final mkAccountService accountService;

    /**
     * Constructor for EventReminderController.
     *
     * @param eventReminderCommand The command responsible for sending event reminder emails.
     * @param ticketService        The service for managing tickets.
     * @param accountService       The service for managing accounts.
     */
    @Autowired
    public EventReminderController(EventReminderCommand eventReminderCommand, mkTicketService ticketService, mkAccountService accountService) {
        this.eventReminderCommand = eventReminderCommand;
        this.ticketService = ticketService;
        this.accountService = accountService;
    }

    /**
     * Endpoint to send event reminder emails.
     */
    @GetMapping("/send-event-reminder")
    public String sendEventReminderEmails() {
        List<mkTicket> tickets = ticketService.findAll();

        for (mkTicket ticket : tickets) {
            mkAccount account = ticket.getAccount();
            if (account != null) {
                eventReminderCommand.execute(account, ticket);
            }
        }
        return "Event Reminder emails sent successfully!";
    }
}
