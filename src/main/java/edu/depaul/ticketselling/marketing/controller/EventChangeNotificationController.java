package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.Purchase;
import edu.depaul.ticketselling.backend.IPurchaseRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private IPurchaseRepository purchaseRepository;

    @Autowired
    public EventChangeNotificationController(EventChangeNotificationCommand eventChangeNotificationCommand, 
                                            IPurchaseRepository purchaseRepository) {
        this.eventChangeNotificationCommand = eventChangeNotificationCommand;
        this.purchaseRepository = purchaseRepository;
    }
    
    @PostMapping("/event-change")
    public ResponseEntity<String> handleEventChangeNotification(Event updatedEvent, boolean isUpdated) {
        if (isUpdated) {
            List<Purchase> purchases = purchaseRepository.findByEvent(updatedEvent);
            for (Purchase purchase : purchases) {
                eventChangeNotificationCommand.execute(purchase.getAccount().getEmailAddress(), updatedEvent);
            }
            return ResponseEntity.ok("Event change notifications sent successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Purchased Event is not updated.");
        }
    }
}
