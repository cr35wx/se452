package edu.depaul.ticketselling.marketing.repository;

import edu.depaul.ticketselling.marketing.model.mAccount;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface mAccountRepository extends JpaRepository<mAccount, Long> {
    /**
    * This feature was added for Event Reminder.
    * src/main/java/edu/depaul/ticketselling/marketing/controller/EventChangeNotificationController.java
    * src/main/java/edu/depaul/ticketselling/marketing/command/OrderConfirmationCommand.java
    * @author Suhwan Kim
    */
    List<String> getEmailsByTicketId(Long id);
    List<String> getEmailsByEventName(String name);
}
