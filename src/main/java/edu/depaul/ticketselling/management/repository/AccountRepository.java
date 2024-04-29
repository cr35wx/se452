package edu.depaul.ticketselling.management.repository;

import edu.depaul.ticketselling.management.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByEmail(String email);
}
