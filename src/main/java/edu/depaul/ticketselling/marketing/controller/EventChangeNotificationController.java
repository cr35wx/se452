package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

// !---- connect with management (Annotation in the event of a backend/management conflict.) ---
// import edu.depaul.ticketselling.management.model.Event;
// import edu.depaul.ticketselling.management.repository.AccountRepository;
// !--------------------------------------------------------------------------------------------

// !---- connect with management (Annotation in the event of a backend/management conflict.) ---
import edu.depaul.ticketselling.marketing.model.mEvent;
import edu.depaul.ticketselling.marketing.repository.mAccountRepository;
// !--------------------------------------------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
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
    // !---- connect with management (Annotation in the event of a backend/management conflict.) ---
    // private final AccountRepository accountRepository;

    // /**
    //  * Constructor for EventChangeNotificationController.
    //  * 
    //  * @param eventChangeNotificationCommand The command responsible for executing event change notifications.
    //  * @param accountRepository              The repository for managing user accounts.
    //  */
    // @Autowired
    // public EventChangeNotificationController(EventChangeNotificationCommand eventChangeNotificationCommand, 
    //                                         AccountRepository accountRepository) {
    //     this.eventChangeNotificationCommand = eventChangeNotificationCommand;
    //     this.accountRepository = accountRepository;
    // }

    // /**
    //  * Handles the notification for event changes.
    //  * 
    //  * @param updatedEvent The updated event information.
    //  * @param isUpdated    A flag indicating if the event has been updated.
    //  */
    // @PostMapping("/evnet-change")
    // public void handleEventChangeNotification(Event updatedEvent, boolean isUpdated) {
    //     List<String> recipientEmails = accountRepository.getEmailsByEventName(updatedEvent.getName());

    //     for (String recipient : recipientEmails) {
    //         eventChangeNotificationCommand.execute(recipient, updatedEvent, isUpdated);
    //     }
    // }

    // /**
    //  * Handles the notification for event deletions.
    //  * 
    //  * @param deletedEvent The event that has been deleted.
    //  */
    // @PostMapping("/evnet-deletion")
    // public void handleEventDeletionNotification(Event deletedEvent) {
    //     List<String> recipientEmails = accountRepository.getEmailsByEventName(deletedEvent.getName());
    
    //     for (String recipient : recipientEmails) {
    //         eventChangeNotificationCommand.execute(recipient, deletedEvent, false);
    //     }
    // }
    // !--------------------------------------------------------------------------------------------

    // !---- connect with management (Annotation in the event of a backend/management conflict.) ---
    private final mAccountRepository accountRepository;
    
    /**
     * Constructor for EventChangeNotificationController.
     * 
     * @param eventChangeNotificationCommand The command responsible for executing event change notifications.
     * @param accountRepository              The repository for managing user accounts.
     */
    @Autowired
    public EventChangeNotificationController(EventChangeNotificationCommand eventChangeNotificationCommand, 
                                            mAccountRepository accountRepository) {
        this.eventChangeNotificationCommand = eventChangeNotificationCommand;
        this.accountRepository = accountRepository;
    }

    /**
     * Handles the notification for event changes.
     * 
     * @param updatedEvent The updated event information.
     * @param isUpdated    A flag indicating if the event has been updated.
     */
    @PostMapping("/evnet-change")
    public void handleEventChangeNotification(mEvent updatedEvent, boolean isUpdated) {
        List<String> recipientEmails = accountRepository.getEmailsByEventName(updatedEvent.getName());

        for (String recipient : recipientEmails) {
            eventChangeNotificationCommand.execute(recipient, updatedEvent, isUpdated);
        }
    }

    /**
     * Handles the notification for event deletions.
     * 
     * @param deletedEvent The event that has been deleted.
     */
    @PostMapping("/evnet-deletion")
    public void handleEventDeletionNotification(mEvent deletedEvent) {
        List<String> recipientEmails = accountRepository.getEmailsByEventName(deletedEvent.getName());
    
        for (String recipient : recipientEmails) {
            eventChangeNotificationCommand.execute(recipient, deletedEvent, false);
        }
    }
    // !--------------------------------------------------------------------------------------------
}
