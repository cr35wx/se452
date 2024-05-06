package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

// !---- connect with backend (Annotation in the event of a backend/management conflict.) ---
// import edu.depaul.ticketselling.backend.User;
// import edu.depaul.ticketselling.backend.Event;
// import edu.depaul.ticketselling.backend.IUserRepository;
// import edu.depaul.ticketselling.backend.IEventRepository;
// !-----------------------------------------------------------------------------------------

// !---- marketing mail standalone(Annotation on the release of the app.) -------------------
import edu.depaul.ticketselling.marketing.model.bUser;
import edu.depaul.ticketselling.marketing.model.bEvent;
import edu.depaul.ticketselling.marketing.repository.bUserRepository;
import edu.depaul.ticketselling.marketing.repository.bEventRepository;
// !-----------------------------------------------------------------------------------------

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

    // !---- connect with backend (Annotation in the event of a backend/management conflict.) ---
    // /**
    //  * UserRepository for accessing user data from the marketing database.
    //  */
    // private final IUserRepository<User> userRepository;
    // /**
    //  * EventRepository for accessing event data from the marketing database.
    //  */
    // private final IEventRepository eventRepository;

    // /**
    //  * Constructor for OnSaleNotificationController.
    //  * 
    //  * @param onSaleNotificationCommand The command for sending on-sale notification emails.
    //  * @param userRepository            Repository for accessing user data.
    //  * @param eventRepository           Repository for accessing event data.
    //  */
    // @Autowired
    // public OnSaleNotificationController(OnSaleNotificationCommand onSaleNotificationCommand, 
    //                                     IUserRepository<User> userRepository, 
    //                                     IEventRepository eventRepository) {
    //     this.onSaleNotificationCommand = onSaleNotificationCommand;
    //     this.userRepository = userRepository;
    //     this.eventRepository = eventRepository;
    // }

    // /**
    //  * Endpoint for sending on-sale notification emails to users.
    //  * 
    //  * @return A message indicating that the on-sale notification emails have been sent successfully.
    //  */
    // @GetMapping("/send-on-sale-notification")
    // public String sendOnSaleNotificationEmails() {
    //     List<User> users = (List<User>) userRepository.findAll();
    //     List<Event> events = (List<Event>) eventRepository.findAll();

    //     for (User user : users) {
    //         onSaleNotificationCommand.execute(user, events);
    //     }

    //     return "On Sale Notification emails sent successfully!";
    // }
    // !-----------------------------------------------------------------------------------------

    // !---- marketing mail standalone(Annotation on the release of the app.) -------------------
    /**
     * UserRepository for accessing user data from the marketing database.
     */
    private final bUserRepository<bUser> userRepository;
    /**
     * EventRepository for accessing event data from the marketing database.
     */
    private final bEventRepository eventRepository;

    /**
     * Constructor for OnSaleNotificationController.
     * 
     * @param onSaleNotificationCommand The command for sending on-sale notification emails.
     * @param userRepository            Repository for accessing user data.
     * @param eventRepository           Repository for accessing event data.
     */
    @Autowired
    public OnSaleNotificationController(OnSaleNotificationCommand onSaleNotificationCommand, 
                                        bUserRepository<bUser> userRepository, 
                                        bEventRepository eventRepository) {
        this.onSaleNotificationCommand = onSaleNotificationCommand;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    /**
     * Endpoint for sending on-sale notification emails to users.
     * 
     * @return A message indicating that the on-sale notification emails have been sent successfully.
     */
    @GetMapping("/send-on-sale-notification")
    public String sendOnSaleNotificationEmails() {
        List<bUser> users = (List<bUser>) userRepository.findAll();
        List<bEvent> events = (List<bEvent>) eventRepository.findAll();

        for (bUser user : users) {
            onSaleNotificationCommand.execute(user, events);
        }

        return "On Sale Notification emails sent successfully!";
    }
    // !-----------------------------------------------------------------------------------------
}
