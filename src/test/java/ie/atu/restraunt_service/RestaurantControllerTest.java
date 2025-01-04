package ie.atu.restraunt_service;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRestaurant() {

        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");

        when(restaurantService.addRestaurant(restaurant)).thenReturn(restaurant);


        Restaurant result = restaurantController.addRestaurant(restaurant);


        assertNotNull(result);
        assertEquals("Test Restaurant", result.getName());
        verify(restaurantService, times(1)).addRestaurant(restaurant);
    }

    @Test
    void testUpdateRestaurant() {

        Restaurant updatedRestaurant = new Restaurant();
        updatedRestaurant.setName("Updated Restaurant");

        when(restaurantService.updateRestaurant(eq("1"), any(Restaurant.class))).thenReturn(updatedRestaurant);


        Restaurant result = restaurantController.updateRestaurant("1", updatedRestaurant);


        assertNotNull(result);
        assertEquals("Updated Restaurant", result.getName());
        verify(restaurantService, times(1)).updateRestaurant(eq("1"), any(Restaurant.class));
    }

    @Test
    void testAddMenuItem() {

        Restaurant restaurant = new Restaurant();
        MenuItem menuItem = new MenuItem();
        menuItem.setName("Pizza");

        when(restaurantService.addMenuItem(eq("1"), any(MenuItem.class))).thenReturn(restaurant);


        Restaurant result = restaurantController.addMenuItem("1", menuItem);


        assertNotNull(result);
        verify(restaurantService, times(1)).addMenuItem(eq("1"), any(MenuItem.class));
    }

    @Test
    void testGetAllRestaurants() {

        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant());

        when(restaurantService.getAllRestaurants()).thenReturn(restaurants);


        List<Restaurant> result = restaurantController.getAllRestaurants();


        assertNotNull(result);
        assertEquals(1, result.size());
        verify(restaurantService, times(1)).getAllRestaurants();
    }

    @Test
    void testGetRestaurantById() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId("1");

        when(restaurantService.getRestaurantById("1")).thenReturn(restaurant);


        Restaurant result = restaurantController.getRestaurantById("1");


        assertNotNull(result);
        assertEquals("1", result.getId());
        verify(restaurantService, times(1)).getRestaurantById("1");
    }
}

