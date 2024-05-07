package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

import edu.depaul.ticketselling.marketing.model.*;
import edu.depaul.ticketselling.marketing.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.marketing.command.EventChangeNotificationCommand;

/**
 * [Marketing and communication]
 * This code is Controller of Event cancellations / changes.
 * 
 * This controller is responsible for handling notifications related to event cancellations or changes.
 * It interacts with the EventChangeNotificationCommand to execute the necessary actions.
 * 
 * Upon receiving a request to handle event change notifications or deletions, it retrieves the recipient
 * emails associated with the affected event from the account repository. Then, it iterates through the list
 * of recipients, executing the appropriate notification command for each recipient.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventChangeNotificationController {
    private EventChangeNotificationCommand eventChangeNotificationCommand;
    private final mkAccountRepository accountRepository;

    @Autowired
    public EventChangeNotificationController(EventChangeNotificationCommand eventChangeNotificationCommand, mkAccountRepository accountRepository) {
        this.eventChangeNotificationCommand = eventChangeNotificationCommand;
        this.accountRepository = accountRepository;
    }

    @PostMapping("/event-change")
    public void handleEventChangeNotification(@RequestBody mkEvent updatedEvent, @RequestParam boolean isUpdated) {
        List<mkAccount> recipients = accountRepository.findAll();
        for (mkAccount recipient : recipients) {
            eventChangeNotificationCommand.sendEventChangeNotification(recipient.getEmail(), updatedEvent, isUpdated);
        }
    }

    @PostMapping("/event-deletion")
    public void handleEventDeletionNotification(@RequestBody mkEvent deletedEvent) {
        List<mkAccount> recipients = accountRepository.findAll();
        for (mkAccount recipient : recipients) {
            eventChangeNotificationCommand.sendEventDeletionNotification(recipient.getEmail(), deletedEvent);
        }
    }
}