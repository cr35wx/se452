package edu.depaul.ticketselling.marketing.controller;

import java.util.List;
import java.util.Optional;

import edu.depaul.ticketselling.backend.IEventRepository;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.management.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.marketing.command.EventCancelNotificationCommand;

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
public class EventCancelNotificationController {
    private final EventCancelNotificationCommand eventCancelNotificationCommand;
    private final IEventRepository eventRepository;
    private final AccountService accountService;

    @Autowired
    public EventCancelNotificationController(EventCancelNotificationCommand eventCancelNotificationCommand,
                                             IEventRepository eventRepository,
                                             AccountService accountService) {
        this.eventCancelNotificationCommand = eventCancelNotificationCommand;
        this.eventRepository = eventRepository;
        this.accountService = accountService;
    }

    @PostMapping("/event-cancel")
    public ResponseEntity<String> handleEventCancellationNotification(@RequestParam Long id) {
        Optional<Event> eventOptional = eventRepository.findById(id);
        if (eventOptional.isPresent()) {
            List<User> users = accountService.findAll();
            Event event = eventOptional.get();
            for (User user : users) {
                eventCancelNotificationCommand.execute(user, event);
            }
            return ResponseEntity.ok("Event cancel notifications sent successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}