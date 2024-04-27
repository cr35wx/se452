package edu.depaul.ticketselling.marketing.command;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

public class OrderConfirmationCommand {
    private EmailService emailService;

    public OrderConfirmationCommand(EmailService emailService) {
        this.emailService = emailService;
    }

    public void execute(String recipient, String eventName) {
        String subject = "Order Confirmation";
        String body = "Thank you for purchasing tickets. Your Order : " + eventName;
        Email email = Email.builder()
                        .recipient(recipient)
                        .subject(subject)
                        .body(body)
                        .build();
        emailService.sendEmail(email);
    }
}