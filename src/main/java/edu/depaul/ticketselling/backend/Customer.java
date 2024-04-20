package edu.depaul.ticketselling.backend;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Defines a general customer with no special permissions.
 * Can purchase {@link Ticket}s
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer implements User {
    @Id
    private long userId;
    private String username;
    private String password;
    private String emailAddress;

    // TODO implement purchase history

}
