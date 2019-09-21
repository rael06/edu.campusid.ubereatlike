package infrastructure;

import domain.Customer;
import domain.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryCustomerRepository implements CustomerRepository {

    private static InMemoryCustomerRepository instance = null;

    private InMemoryCustomerRepository() { }

    public static InMemoryCustomerRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryCustomerRepository.class) {
                instance = instance == null ? new InMemoryCustomerRepository() : instance;
                instance.add(new Customer("0", "rael06@hotmail.fr", "pass"));
            }
        }
        return instance;
    }

    private List<Customer> customers = new ArrayList<>();

    @Override
    public void add(Customer c) {
        customers.add(c);
    }

    @Override
    public Optional<Customer> findByEmailAndPassword(String email, String password) {
        return customers.stream().filter(c -> c.getEmail().equals(email) &&
                c.getPassword().equals(password)).findFirst();
    }
}
