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
    }
}
