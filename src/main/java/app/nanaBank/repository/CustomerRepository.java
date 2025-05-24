package app.nanaBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.nanaBank.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
