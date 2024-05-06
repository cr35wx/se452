package edu.depaul.ticketselling.backend;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository<T extends User> extends CrudRepository<T, Long> {
    User findUserByName(String username);
    User findUserByEmail(String email);
    User findUserByPhone(String phoneNumber);
    User findUserById(Long id);
    User findByEmailAndPassword(String email, String password);
    /**
    * This feature was added for Event Reminder.
    * src/main/java/edu/depaul/ticketselling/marketing/controller/EventReminderController.java
    * @author Suhwan Kim
    */
    List<User> findUsersByEvent(Event event);
}
