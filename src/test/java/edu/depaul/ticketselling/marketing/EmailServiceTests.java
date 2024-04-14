package edu.depaul.ticketselling.marketing;

import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

public class EmailServiceTests {

    @Test
    public void testSendOrderConfirmationEmail() {
        // Mock EmailService 생성
        EmailService emailService = mock(EmailService.class);
        OrderConfirmationService orderConfirmationService = new OrderConfirmationService(emailService);

        // 주문 확인 이메일 전송
        String recipient = "test@example.com";
        String eventName = "Test Event";
        orderConfirmationService.sendOrderConfirmationEmail(recipient, eventName);

        // EmailService의 sendEmail 메서드가 한 번 호출되었는지 검증
        verify(emailService, times(1)).sendEmail(any(Email.class));
    }

    @Test
    public void testSendEventReminderEmail() {
        // Mock EmailService 생성
        EmailService emailService = mock(EmailService.class);
        EventReminderService eventReminderService = new EventReminderService(emailService);

        // 이벤트 알림 이메일 전송
        String recipient = "test@example.com";
        String eventName = "Test Event";
        LocalDateTime eventDateTime = LocalDateTime.now().plusDays(1);
        eventReminderService.sendEventReminderEmail(recipient, eventName, eventDateTime);

        // EmailService의 sendEmail 메서드가 한 번 호출되었는지 검증
        verify(emailService, times(1)).sendEmail(any(Email.class));
    }
}