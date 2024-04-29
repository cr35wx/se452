package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The abstract User class serves as a base for the general {@link Customer} class and {@link Admin} class.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) private long userId;
    private String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private LocalDateTime creationDate;
}
