package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.IEventRepository;
import edu.depaul.ticketselling.backend.IPurchaseRepository;
import edu.depaul.ticketselling.backend.Purchase;
import edu.depaul.ticketselling.marketing.command.EventReminderCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventReminderController {
    private final EventReminderCommand eventReminderCommand;
    private final IPurchaseRepository purchaseRepository;
    private final IEventRepository eventRepository;

    /**
     * Constructor for EventReminderController.
     */
    @Autowired
    public EventReminderController(EventReminderCommand eventReminderCommand,
                                    IEventRepository eventRepository,
                                    IPurchaseRepository purchaseRepository) {
        this.eventReminderCommand = eventReminderCommand;
        this.eventRepository = eventRepository;
        this.purchaseRepository = purchaseRepository;
    }

    /**
     * Endpoint to send event reminder emails.
     */
    @Scheduled(cron = "0 0 0 * * *")
    @PostMapping("/send-event-reminder")
    public void sendEventReminderEmails() {
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);
        LocalDateTime twentyFourHoursLater = now.plusHours(24).withSecond(0).withNano(0);
        List<Event> events = (List<Event>) eventRepository.findByDateTimeBetween(now, twentyFourHoursLater);
        for (Event event : events) {
            List<Purchase> purchases = (List<Purchase>) purchaseRepository.findByEvent(event);
            for (Purchase purchase : purchases) {
                eventReminderCommand.execute(purchase);
            }
        }
    }
}
