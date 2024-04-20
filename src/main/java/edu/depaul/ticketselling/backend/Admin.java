package edu.depaul.ticketselling.backend;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * An Administrator that has elevated permissions to create, edit, or delete an {@link Event}.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin implements User {
    @Id
    private long userId;
    private String username;
    private String password;
    private String emailAddress;

    // TODO implement purchase history

}
