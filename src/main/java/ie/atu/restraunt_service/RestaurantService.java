package ie.atu.restraunt_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    // Add a new restaurant
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    // Update restaurant details
    public Restaurant updateRestaurant(String id, Restaurant restaurantDetails) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(id);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.setName(restaurantDetails.getName());
            restaurant.setAddress(restaurantDetails.getAddress());
            restaurant.setContact(restaurantDetails.getContact());
            restaurant.setCuisine(restaurantDetails.getCuisine());
            restaurant.setOperatingHours(restaurantDetails.getOperatingHours());
            return restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant not found");
    }

    // Add a menu item to a restaurant
    public Restaurant addMenuItem(String restaurantId, MenuItem menuItem) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.getMenu().add(menuItem);
            return restaurantRepository.save(restaurant);
        }
        throw new RuntimeException("Restaurant not found");
    }

    // Retrieve all restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    // Retrieve a restaurant by ID
    public Restaurant getRestaurantById(String id) {
        return restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }
}

