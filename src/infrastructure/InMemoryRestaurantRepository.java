package infrastructure;

import domain.Restaurant;
import domain.repositories.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryRestaurantRepository implements RestaurantRepository {
    private static InMemoryRestaurantRepository instance = null;

    private List<Restaurant> restaurants = new ArrayList<>();

    private InMemoryRestaurantRepository() { }

    public static InMemoryRestaurantRepository getInstance() {
        if (instance == null) {
            synchronized (InMemoryRestaurantRepository.class) {
                instance = instance == null ? new InMemoryRestaurantRepository() : instance;
                instance.add(new Restaurant("1", "Burger King", "30 Minutes", "Burger"));
                instance.add(new Restaurant("2", "MCDO", "10 Minutes", "Burger"));
                instance.add(new Restaurant("3", "Dominos", "25 Minutes", "Pizza"));
            }
        }
        return instance;
    }

    @Override
    public void add(Restaurant r) {
        restaurants.add(r);
    }

    @Override
    public List<Restaurant> findByType(String type) {
        return restaurants.stream().filter(r -> r.getType().toLowerCase().equals(type.toLowerCase()))
                .collect(Collectors.toList());
    }
}
