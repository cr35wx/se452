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

    public Customer(long id, String email, String password, String phoneNumber, LocalDateTime creationTime) {
        super(id, email, password, phoneNumber, creationTime);
    }

    @Override
    public String toString() {
        return String.format("User ID: %d%nEmail: %s%nPhone: %s",
                getUserId(), getEmailAddress(), getPhoneNumber()
        );
    }

}
