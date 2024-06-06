package edu.depaul.ticketselling.backend;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for generic CRUD operations on a User repository
 */
public interface IUserRepository<T extends User> extends CrudRepository<T, Long> {
    User findUserByEmailAddress(String emailAddress);
    User findUserByPhoneNumber(String phoneNumber);
    User findUserByUserId(Long userId);
    User findByEmailAddressAndPassword(String emailAddress, String password);
}
