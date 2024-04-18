package edu.depaul.ticketselling.backend;

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
    @Id
    private long userId;
    private String username;
    private String password;
    private String emailAddress;

    // TODO implement purchase history

}