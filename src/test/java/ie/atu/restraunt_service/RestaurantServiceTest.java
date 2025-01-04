package ie.atu.restraunt_service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRestaurant() {

        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");

        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);

        Restaurant result = restaurantService.addRestaurant(restaurant);


        assertNotNull(result);
        assertEquals("Test Restaurant", result.getName());
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    void testUpdateRestaurant() {

        Restaurant existingRestaurant = new Restaurant();
        existingRestaurant.setId("1");
        existingRestaurant.setName("Old Name");

        Restaurant updatedDetails = new Restaurant();
        updatedDetails.setName("New Name");

        when(restaurantRepository.findById("1")).thenReturn(Optional.of(existingRestaurant));
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(updatedDetails);


        Restaurant result = restaurantService.updateRestaurant("1", updatedDetails);


        assertNotNull(result);
        assertEquals("New Name", result.getName());
        verify(restaurantRepository, times(1)).findById("1");
        verify(restaurantRepository, times(1)).save(any(Restaurant.class));
    }

    @Test
    void testAddMenuItem() {

        Restaurant restaurant = new Restaurant();
        restaurant.setId("1");
        restaurant.setMenu(new ArrayList<>());

        MenuItem menuItem = new MenuItem();
        menuItem.setName("Burger");

        when(restaurantRepository.findById("1")).thenReturn(Optional.of(restaurant));
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);


        Restaurant result = restaurantService.addMenuItem("1", menuItem);


        assertNotNull(result);
        assertEquals(1, result.getMenu().size());
        assertEquals("Burger", result.getMenu().get(0).getName());
        verify(restaurantRepository, times(1)).findById("1");
        verify(restaurantRepository, times(1)).save(restaurant);
    }

    @Test
    void testGetAllRestaurants() {

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant());
        when(restaurantRepository.findAll()).thenReturn(restaurants);


        List<Restaurant> result = restaurantService.getAllRestaurants();


        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restaurantRepository, times(1)).findAll();
    }

    @Test
    void testGetRestaurantById() {

        Restaurant restaurant = new Restaurant();
        restaurant.setId("1");
        when(restaurantRepository.findById("1")).thenReturn(Optional.of(restaurant));
        Restaurant result = restaurantService.getRestaurantById("1");


        assertNotNull(result);
        assertEquals("1", result.getId());
        verify(restaurantRepository, times(1)).findById("1");
    }
}

