package edu.depaul.ticketselling.marketing;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * On-sale notifications
 * 
 * @author Suhwan Kim
 */
public class OnSaleNotificationService {
    private EmailService emailService;

    public OnSaleNotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendOnSaleNotificationEmail(String recipient, String eventName) {
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