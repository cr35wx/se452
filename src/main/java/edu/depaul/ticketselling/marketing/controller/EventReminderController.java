package edu.depaul.ticketselling.marketing.controller;

import java.time.LocalDateTime;
import edu.depaul.ticketselling.marketing.command.EventReminderCommand;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Event reminders
 * 
 * @author Suhwan Kim
 */

public class EventReminderController {
    private EventReminderCommand eventReminderCommand;

    public EventReminderController(EventReminderCommand eventReminderCommand) {
        this.eventReminderCommand = eventReminderCommand;
    }

    public void handleEventReminder(String recipient, String eventName, LocalDateTime eventDateTime) {
        eventReminderCommand.execute(recipient, eventName, eventDateTime);
    }
}
