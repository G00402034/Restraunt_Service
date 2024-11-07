package ie.atu.restraunt_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class RestrauntService {
    @Service
    public class RestaurantService {

        @Autowired
        private RestrauntRepository restrauntRepository;

        public Restraunt createRestaurant(Restraunt restaurant) {
            return restrauntRepository.save(restaurant);
        }

        public Optional<Restraunt> getRestaurantById(String id) {
            return restrauntRepository.findById(id);
        }

        public Restraunt updateRestaurant(String id, Restraunt restaurantData) {
            Optional<Restraunt> restaurantOptional = restrauntRepository.findById(id);
            if (restaurantOptional.isPresent()) {
                Restraunt restaurant = restaurantOptional.get();
                restaurant.setName(restaurantData.getName());
                restaurant.setAddress(restaurantData.getAddress());
                restaurant.setContactNumber(restaurantData.getContactNumber());
                restaurant.setCuisine(restaurantData.getCuisine());
                restaurant.setOperatingHours(restaurantData.getOperatingHours());
                restaurant.setMenu(restaurantData.getMenu());
                restaurant.setRating(restaurantData.getRating());
                return restrauntRepository.save(restaurant);
            }
            throw new RuntimeException("Restaurant not found");
        }

        public void deleteRestaurant(String id) {
            restrauntRepository.deleteById(id);
        }

        public boolean checkAvailability(String id) {
            Optional<Restraunt> restaurant = restrauntRepository.findById(id);
            return restaurant.map(Restraunt::isAvailable).orElse(false);
        }

        public void addReview(String id, Review review) {
            Optional<Restraunt> restaurantOptional = restrauntRepository.findById(id);
            restaurantOptional.ifPresent(restaurant -> {
                restaurant.getReviews().add(review);
                restrauntRepository.save(restaurant);
            });
        }
    }
    }

