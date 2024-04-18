package edu.depaul.ticketselling.backend;

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
@Table("customers")
public class Customer implements User {
    @Id
    private long userId;
    private String username;
    private String password;
    private String emailAddress;

    // TODO implement purchase history

}
