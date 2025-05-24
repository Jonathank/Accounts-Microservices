package app.nanaBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.nanaBank.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    // Additional query methods can be defined here if needed

}
