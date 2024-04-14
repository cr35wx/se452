package edu.depaul.ticketselling.marketing;

import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class EmailServiceTests {

    @Test
    public void testSendOrderConfirmationEmail() {
        EmailService emailService = mock(EmailService.class);
        OrderConfirmationService orderConfirmationService = new OrderConfirmationService(emailService);

        String recipient = "test@example.com";
        String eventName = "Test Event";
        orderConfirmationService.sendOrderConfirmationEmail(recipient, eventName);

        verify(emailService, times(1)).sendEmail(any(Email.class));
    }

    @Test
    public void testSendEventReminderEmail() {
        EmailService emailService = mock(EmailService.class);
        EventReminderService eventReminderService = new EventReminderService(emailService);

        String recipient = "test@example.com";
        String eventName = "Test Event";
        LocalDateTime eventDateTime = LocalDateTime.now().plusDays(1);
        eventReminderService.sendEventReminderEmail(recipient, eventName, eventDateTime);

        verify(emailService, times(1)).sendEmail(any(Email.class));
    }
}
