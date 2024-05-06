package edu.depaul.ticketselling.marketing.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.depaul.ticketselling.marketing.model.bEvent;
import edu.depaul.ticketselling.marketing.model.bUser;

public interface bUserRepository<T extends bUser> extends CrudRepository<T, Long> {
    bUser findUserByUsername(String username);
    bUser findUserByEmailAddress(String emailAddress);
    bUser findUserByPhoneNumber(String phoneNumber);
    bUser findUserByUserId(Long userId);
    bUser findByEmailAddressAndPassword(String emailAddress, String password);
    /**
    * This feature was added for Event Reminder.
    * src/main/java/edu/depaul/ticketselling/marketing/controller/EventReminderController.java
    * @author Suhwan Kim
    */
    List<bUser> findUsersByEvent(bEvent event);
}
