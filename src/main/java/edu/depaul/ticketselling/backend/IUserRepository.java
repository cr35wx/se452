package edu.depaul.ticketselling.backend;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepository<T extends User> extends CrudRepository<T, Long> {
    User findUserByName(String username);
    User findUserByEmail(String email);
    User findUserByPhone(String phoneNumber);
    User findUserById(Long id);
}
