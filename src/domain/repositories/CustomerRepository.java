package domain.repositories;

import domain.Customer;

import java.util.Optional;

public interface CustomerRepository {
    void add(Customer c);
    Optional<Customer> findByEmailAndPassword(String email, String password);
}
