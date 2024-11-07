package ie.atu.restraunt_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
    @RequestMapping("/api/restraunts")
    public class RestrauntController {

        @Autowired
        private RestrauntService restrauntService;

        @PostMapping
        public Restraunt createRestraunt(@RequestBody Restraunt restraunt) {
            return  restrauntService.createRestraunt(restraunt);
        }

        @GetMapping("/{id}")
        public Optional<Restraunt> getRestrauntById(@PathVariable String id) {
            return  restrauntService.getRestrauntById(id);
        }

        @PutMapping("/{id}")
        public Restraunt updateRestraunt(@PathVariable String id, @RequestBody Restraunt restaurantData) {
            return  restrauntService.updateRestraunt(id, restaurantData);
        }

        @DeleteMapping("/{id}")
        public void deleteRestraunt(@PathVariable String id) {
            restrauntService.deleteRestraunt(id);
        }

        @GetMapping("/{id}/availability")
        public boolean checkAvailability(@PathVariable String id) {
            return  restrauntService.checkAvailability(id);
        }

        @PostMapping("/{id}/reviews")
        public void addReview(@PathVariable String id, @RequestBody Review review) {
            restrauntService.addReview(id, review);
        }
    }


