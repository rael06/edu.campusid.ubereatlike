package infrastructure;

public class InMemoryAbstractRepository {
    private static InMemoryAbstractRepository instance = null;

    private InMemoryAbstractRepository() { }

    public static InMemoryAbstractRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryCustomerRepository.class) {
                instance = instance == null ? new InMemoryAbstractRepository() : instance;
            }
        }
        return instance;
    }
}
