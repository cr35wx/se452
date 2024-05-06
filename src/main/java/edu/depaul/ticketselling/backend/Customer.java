package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Defines a general customer with no special permissions.
 * Can purchase {@link Ticket}s.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Customer extends User {

    public Customer(long id, String username, String password, String email, String phoneNumber, LocalDateTime creationTime) {
        super(id, username, password, email, phoneNumber, creationTime);
    }

    @Override
    public String toString() {
        return String.format("User %s, User ID: %d%nEmail: %s%nPhone: %s",
                getUsername(), getUserId(), getEmailAddress(), getPhoneNumber()
        );
    }

}
