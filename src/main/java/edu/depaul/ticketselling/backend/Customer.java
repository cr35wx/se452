package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Defines a general customer with no special permissions.
 * Can purchase {@link Ticket}s
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("accounts")
public class Customer implements User {
    @Id private long userId;
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private LocalDateTime creationDate;

    @Override
    public String toString() {
        return String.format("User %s, User ID: %d%nEmail: %s%nPhone: %s", username, userId, emailAddress, phoneNumber);
    }

}
