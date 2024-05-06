package edu.depaul.ticketselling.marketing.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.depaul.ticketselling.marketing.command.EventReminderCommand;
import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.IEventRepository;
import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.IUserRepository;

/**
 * [Marketing and communication]
 * This code is the Controller of Event reminders.
 * 
 * @author Suhwan Kim
 */
@RestController
@RequestMapping("/email")
@Component
public class EventReminderController {
    private final EventReminderCommand eventReminderCommand;
    private final IUserRepository<User> userRepository;
    private final IEventRepository eventRepository;

    @Autowired
    public EventReminderController(EventReminderCommand eventReminderCommand, IUserRepository<User> userRepository, IEventRepository eventRepository) {
        this.eventReminderCommand = eventReminderCommand;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/send-event-reminder")
    public String sendEventReminderEmails() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime twentyFourHoursLater = now.plusDays(1);

        List<Event> events = (List<Event>) eventRepository.findAll();

        for (Event event : events) {
            LocalDateTime eventDateTime = event.getDateTime();
            if (eventDateTime.isAfter(now) && eventDateTime.isBefore(twentyFourHoursLater)) {
                List<User> users = userRepository.findUsersByEvent(event);
                for (User user : users) {
                    eventReminderCommand.execute(user, event);
                }
            }
        }

        return "Event Reminder emails sent successfully!";
    }
}
