package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.depaul.ticketselling.marketing.command.EventChangeNotificationCommand;
import edu.depaul.ticketselling.management.repository.AccountRepository;
import edu.depaul.ticketselling.management.model.Event;

/**
 * [Marketing and communication]
 * This code is Controller of Event cancellations / changes.
 * 
 * @author Suhwan Kim
 */
@Component
public class EventChangeNotificationController {
    private EventChangeNotificationCommand eventChangeNotificationCommand;
    private final AccountRepository accountRepository;

    public EventChangeNotificationController(EventChangeNotificationCommand eventChangeNotificationCommand, 
                                            AccountRepository accountRepository) {
        this.eventChangeNotificationCommand = eventChangeNotificationCommand;
        this.accountRepository = accountRepository;
    }
    
    public void handleEventChangeNotification(Event updatedEvent, boolean isUpdated) {
        List<String> recipientEmails = accountRepository.getEmailsByEventName(updatedEvent.getName());

        for (String recipient : recipientEmails) {
            eventChangeNotificationCommand.execute(recipient, updatedEvent, isUpdated);
        }
    }

    public void handleEventDeletionNotification(Event deletedEvent) {
        List<String> recipientEmails = accountRepository.getEmailsByEventName(deletedEvent.getName());
    
        for (String recipient : recipientEmails) {
            eventChangeNotificationCommand.execute(recipient, deletedEvent, false);
        }
    }
}
