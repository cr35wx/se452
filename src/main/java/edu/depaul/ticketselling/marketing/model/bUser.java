package edu.depaul.ticketselling.marketing.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public abstract class bUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(nullable = false, length = 256)
    private String username;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(unique = true, nullable = false, length = 254)
    private String emailAddress;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    // User Event added
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserEvent> userEvents;

    public void addUserEvent(UserEvent userEvent) {
        userEvents.add(userEvent);
    }

}
