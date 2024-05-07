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

    public Admin(long id, String email, String password, String phoneNumber, LocalDateTime creationTime) {
        super(id, email, password, phoneNumber, creationTime);
    }

    @Override
    public String toString() {
        return String.format("Administrator, User ID: %d%nEmail: %s%nPhone: %s",
                getUserId(), getEmailAddress(), getPhoneNumber()
        );
    }

}