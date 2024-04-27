package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * On-sale notifications
 * 
 * @author Suhwan Kim
 */
public class OnSaleNotificationCommand {
    private EmailService emailService;

    public OnSaleNotificationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(String recipient, String eventName) {
        String subject = "New Event On Sale";
        String body = "Good news! Tickets for " + eventName + " are now on sale.";
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        emailService.sendEmail(email);
    }
}