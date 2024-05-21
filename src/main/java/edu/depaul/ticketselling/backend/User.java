package edu.depaul.ticketselling.backend;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "accounts")
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(unique = true, nullable = false, length = 254)
    private String emailAddress;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime creationDate;

}
