package ie.atu.restraunt_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RestaurantServiceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testAddRestaurant() {

        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        restaurant.setAddress("123 Main St");
        restaurant.setCuisine("Italian");
        restaurant.setContact("123-456-7890");

        ResponseEntity<Restaurant> response = restTemplate.postForEntity("/api/restaurants", restaurant, Restaurant.class);


        assertEquals(201, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("Test Restaurant", response.getBody().getName());
    }

    @Test
    void testGetAllRestaurants() {

        ResponseEntity<List> response = restTemplate.getForEntity("/api/restaurants", List.class);


        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
    }
}
