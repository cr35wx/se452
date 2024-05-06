package edu.depaul.ticketselling.management.repository;

import edu.depaul.ticketselling.management.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmailAndPassword(String email, String password);

    /**
    * This feature was added for Event Reminder.
    * src/main/java/edu/depaul/ticketselling/marketing/controller/EventChangeNotificationController.java
    * src/main/java/edu/depaul/ticketselling/marketing/command/OrderConfirmationCommand.java
    * @author Suhwan Kim
    */
    List<String> getEmailsByTicketId(Long id);
    List<String> getEmailsByEventName(String name);
}
