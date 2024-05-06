package edu.depaul.ticketselling.marketing.controller;

import java.time.LocalDateTime;
import java.util.List;
// !---- connect with backend (Annotation in the event of a backend/management conflict.) ---
// import edu.depaul.ticketselling.backend.Event;
// import edu.depaul.ticketselling.backend.User;
// import edu.depaul.ticketselling.backend.IEventRepository;
// import edu.depaul.ticketselling.backend.IUserRepository;
// !-----------------------------------------------------------------------------------------

// !---- marketing mail standalone(Annotation on the release of the app.) -------------------
import edu.depaul.ticketselling.marketing.model.bEvent;
import edu.depaul.ticketselling.marketing.model.bUser;
import edu.depaul.ticketselling.marketing.repository.bEventRepository;
import edu.depaul.ticketselling.marketing.repository.bUserRepository;
// !-----------------------------------------------------------------------------------------

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.depaul.ticketselling.marketing.command.EventReminderCommand;

/**
 * [Marketing and communication]
 * This code is the Controller of Event reminders.
 * 
 * This controller is responsible for sending event reminder emails to users.
 * It interacts with the EventReminderCommand to execute the logic for sending emails.
 * 
 * It retrieves the list of events from the marketing database repositories and checks
 * if any events are scheduled within the next 24 hours. If so, it retrieves the list of users
 * registered for those events and sends event reminder emails to them.
 * 
 * Upon successful execution, it returns a message indicating that the event reminder emails
 * have been sent successfully.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventReminderController {
    private final EventReminderCommand eventReminderCommand;
    // !---- connect with backend (Annotation in the event of a backend/management conflict.) ---
    // /**
    //  * Repository for accessing user data from the marketing database.
    //  */
    // private final IUserRepository<User> userRepository;
    // /**
    //  * Repository for accessing event data from the marketing database.
    //  */
    // private final IEventRepository eventRepository;

    // /**
    //  * Constructor for EventReminderController.
    //  * 
    //  * @param eventReminderCommand The command for sending event reminder emails.
    //  * @param userRepository       Repository for accessing user data.
    //  * @param eventRepository      Repository for accessing event data.
    //  */
    // @Autowired
    // public EventReminderController(EventReminderCommand eventReminderCommand, IUserRepository<User> userRepository, IEventRepository eventRepository) {
    //     this.eventReminderCommand = eventReminderCommand;
    //     this.userRepository = userRepository;
    //     this.eventRepository = eventRepository;
    // }

    // /**
    //  * Endpoint for sending event reminder emails to users.
    //  * 
    //  * @return A message indicating that the event reminder emails have been sent successfully.
    //  */
    // @GetMapping("/send-event-reminder")
    // public String sendEventReminderEmails() {
    //     LocalDateTime now = LocalDateTime.now();
    //     LocalDateTime twentyFourHoursLater = now.plusDays(1);

    //     List<Event> events = (List<Event>) eventRepository.findAll();

    //     for (Event event : events) {
    //         LocalDateTime eventDateTime = event.getDateTime();
    //         if (eventDateTime.isAfter(now) && eventDateTime.isBefore(twentyFourHoursLater)) {
    //             List<User> users = userRepository.findUsersByEvent(event);
    //             for (User user : users) {
    //                 eventReminderCommand.execute(user, event);
    //             }
    //         }
    //     }
    //     return "Event Reminder emails sent successfully!";
    // }
    // !-----------------------------------------------------------------------------------------

    // !---- marketing mail standalone(Annotation on the release of the app.) -------------------
    /**
     * Repository for accessing user data from the marketing database.
     */
    private final bUserRepository<bUser> userRepository;
    /**
     * Repository for accessing event data from the marketing database.
     */
    private final bEventRepository eventRepository;

    /**
     * Constructor for EventReminderController.
     * 
     * @param eventReminderCommand The command for sending event reminder emails.
     * @param userRepository       Repository for accessing user data.
     * @param eventRepository      Repository for accessing event data.
     */
    @Autowired
    public EventReminderController(EventReminderCommand eventReminderCommand, bUserRepository<bUser> userRepository, bEventRepository eventRepository) {
        this.eventReminderCommand = eventReminderCommand;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    /**
     * Endpoint for sending event reminder emails to users.
     * 
     * @return A message indicating that the event reminder emails have been sent successfully.
     */
    @GetMapping("/send-event-reminder")
    public String sendEventReminderEmails() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime twentyFourHoursLater = now.plusDays(1);

        List<bEvent> events = (List<bEvent>) eventRepository.findAll();

        for (bEvent event : events) {
            LocalDateTime eventDateTime = event.getDateTime();
            if (eventDateTime.isAfter(now) && eventDateTime.isBefore(twentyFourHoursLater)) {
                List<bUser> users = userRepository.findUsersByEvent(event);
                for (bUser user : users) {
                    eventReminderCommand.execute(user, event);
                }
            }
        }
        return "Event Reminder emails sent successfully!";
    }
    // !-----------------------------------------------------------------------------------------
}
