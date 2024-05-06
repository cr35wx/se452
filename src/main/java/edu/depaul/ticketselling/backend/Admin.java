package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * An Administrator that has elevated permissions to create, edit, or delete an {@link Event}.
 */
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {

    public Admin(long id, String username, String password, String email, String phoneNumber, LocalDateTime creationTime) {
        super(id, username, password, email, phoneNumber, creationTime);
    }

    @Override
    public String toString() {
        return String.format("Administrator %s, User ID: %d%nEmail: %s%nPhone: %s",
                getUsername(), getUserId(), getEmailAddress(), getPhoneNumber()
        );
    }

}