package edu.depaul.ticketselling.marketing.controller;

import edu.depaul.ticketselling.backend.User;
import edu.depaul.ticketselling.backend.Event;
import edu.depaul.ticketselling.backend.IUserRepository;
import edu.depaul.ticketselling.backend.IEventRepository;
import edu.depaul.ticketselling.marketing.command.OnSaleNotificationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/email")
@Component
/**
 * [Marketing and communication]
 * This code is the Controller of On Sale Notification.
 * 
 * @author Suhwan Kim
 */
public class OnSaleNotificationController {
    private final OnSaleNotificationCommand onSaleNotificationCommand;
    private final IUserRepository<User> userRepository;
    private final IEventRepository eventRepository;

    @Autowired
    public OnSaleNotificationController(OnSaleNotificationCommand onSaleNotificationCommand, IUserRepository<User> userRepository, IEventRepository eventRepository) {
        this.onSaleNotificationCommand = onSaleNotificationCommand;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("/send-on-sale-notification")
    public String sendOnSaleNotificationEmails() {
        List<User> users = (List<User>) userRepository.findAll();
        List<Event> events = (List<Event>) eventRepository.findAll();

        for (User user : users) {
            onSaleNotificationCommand.execute(user, events);
        }

        return "On Sale Notification emails sent successfully!";
    }
}
