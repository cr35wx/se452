package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An Administrator that has elevated permissions to create, edit, or delete an {@link Event}.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("admins")
public class Admin implements User {
    @Id private long userId;
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private LocalDateTime creationDate;

    @Override
    public String toString() {
        return String.format("Administrator %s, User ID: %d%nEmail: %s%nPhone: %s", username, userId, emailAddress, phoneNumber);
    }

}