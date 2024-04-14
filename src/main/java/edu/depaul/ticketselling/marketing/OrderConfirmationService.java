package edu.depaul.ticketselling.marketing;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * Order confirmations
 * 
 * @author Suhwan Kim
 */
public class OrderConfirmationService {
    private EmailService emailService;

    public OrderConfirmationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendOrderConfirmationEmail(String recipient, String eventName) {
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