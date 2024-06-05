package edu.depaul.ticketselling.marketing.controller;

import java.util.List;

import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.IUserRepository;
import edu.depaul.ticketselling.backend.IEventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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
    private final IUserRepository<User> userRepository;
    private final IEventRepository eventRepository;

    /**
     * Constructor for OnSaleNotificationController.
     */
    @Autowired
    public OnSaleNotificationController(OnSaleNotificationCommand onSaleNotificationCommand, 
                                        IUserRepository<User> userRepository, 
                                        IEventRepository eventRepository) {
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
        List<User> users = (List<User>) userRepository.findAll();
        List<Event> events = (List<Event>) eventRepository.findAll();

        for (User user : users) {
            onSaleNotificationCommand.execute(user, events);
        }

        return "On Sale Notification emails sent successfully!";
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void scheduleOnSaleNotification() {
        sendOnSaleNotificationEmails();
    }
}
