package edu.depaul.ticketselling.marketing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.depaul.ticketselling.marketing.service.Email;
import edu.depaul.ticketselling.marketing.service.EmailService;

@Component
public class EmailTest implements CommandLineRunner {

    @Autowired
    private EmailService emailService;

    @Override
    public void run(String... args) throws Exception {
        Email email = new Email();
        email.setRecipient("shkim901101@naver.com");
        email.setSubject("Test Email");
        email.setBody("This is a test email!");

        emailService.sendEmail(email);
    }
}