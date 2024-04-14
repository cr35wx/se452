package edu.depaul.ticketselling.marketing;

import org.springframework.stereotype.Service;

/**
 * [Marketing and communication]
 * This code is the skeleton of the E-mail marketing service.
 * 
 * @author Suhwan Kim
 */

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(Email email) {
        // I'm going to implement e-mail transfer logic here...

        System.out.println("Sending email to: " + email.getRecipient());
        System.out.println("Subject: " + email.getSubject());
        System.out.println("Body: " + email.getBody());
        System.out.println("Email sent successfully!");
    }
}
