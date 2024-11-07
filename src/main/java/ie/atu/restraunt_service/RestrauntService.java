package ie.atu.restraunt_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RestrauntService {

        @Autowired
        private RestrauntRepository restrauntRepository;

        public Restraunt createRestraunt(Restraunt restraunt) {
            return restrauntRepository.save(restraunt);
        }

        public Optional<Restraunt> getRestrauntById(String id) {
            return restrauntRepository.findById(id);
        }

        public Restraunt updateRestraunt(String id, Restraunt restrauntData) {
            Optional<Restraunt> restaurantOptional = restrauntRepository.findById(id);
            if (restaurantOptional.isPresent()) {
                Restraunt restaurant = restaurantOptional.get();
                restaurant.setName(restrauntData.getName());
                restaurant.setAddress(restrauntData.getAddress());
                restaurant.setContactNumber(restrauntData.getContactNumber());
                restaurant.setCuisine(restrauntData.getCuisine());
                restaurant.setOperatingHours(restrauntData.getOperatingHours());
                restaurant.setMenu(restrauntData.getMenu());
                restaurant.setRating(restrauntData.getRating());
                return restrauntRepository.save(restaurant);
            }
            throw new RuntimeException("Restaurant not found");
        }

        public void deleteRestraunt(String id) {
            restrauntRepository.deleteById(id);
        }

        public boolean checkAvailability(String id) {
            Optional<Restraunt> restraunt = restrauntRepository.findById(id);
            return restraunt.map(Restraunt::isAvailable).orElse(false);
        }

        public void addReview(String id, Review review) {
            Optional<Restraunt> restrauntOptional = restrauntRepository.findById(id);
            restrauntOptional.ifPresent(restraunt -> {
                restraunt.getReviews().add(review);
                restrauntRepository.save(restraunt);
            });
        }
    }


