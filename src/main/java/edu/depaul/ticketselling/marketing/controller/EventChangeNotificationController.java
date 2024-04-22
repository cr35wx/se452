package edu.depaul.ticketselling.marketing.controller;

import java.time.LocalDateTime;
import edu.depaul.ticketselling.marketing.command.EventChangeNotificationCommand;
/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Event cancellations / changes
 * 
 * @author Suhwan Kim
 */
public class EventChangeNotificationController {
    private EventChangeNotificationCommand eventChangeNotificationCommand;

    public EventChangeNotificationController(EventChangeNotificationCommand eventChangeNotificationCommand) {
        this.eventChangeNotificationCommand = eventChangeNotificationCommand;
    }

    public void handleEventChangeNotification(String recipient, String eventName, LocalDateTime eventDateTime) {
        eventChangeNotificationCommand.execute(recipient, eventName, eventDateTime);
    }
}