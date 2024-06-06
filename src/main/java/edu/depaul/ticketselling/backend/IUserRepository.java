package edu.depaul.ticketselling.backend;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a User repository.
 *
 * @see User
 */
public interface IUserRepository<T extends User> extends CrudRepository<T, Long> {
    /**
     * Locate a user by their email address.
     * @param emailAddress  the user's email address
     * @return  A user with the matching email address.
     */
    User findUserByEmailAddress(String emailAddress);

    /**
     * Locate a user by their phone number.
     * @param phoneNumber   the user's phone number
     * @return  A user with the matching phone number.
     */
    User findUserByPhoneNumber(String phoneNumber);

    /**
     * Locate a user by their user ID.
     * @param userId    the user id to locate
     * @return  A user with the matching ID.
     */
    User findUserByUserId(Long userId);

    /**
     * Locate a user given their email address and password.
     * @param emailAddress  the user's email address
     * @param password  the user's password
     * @return  A user with the matching email and password.
     */
    User findByEmailAddressAndPassword(String emailAddress, String password);
}
