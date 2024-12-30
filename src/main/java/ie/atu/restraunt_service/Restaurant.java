package ie.atu.restraunt_service;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

    @Document(collection = "restaurants")
    @Data
    public class Restaurant {
        @Id
        private String id;
        private String name;
        private String address;
        private String contact;
        private String cuisine; // e.g., Italian, Chinese
        private List<MenuItem> menu; // List of menu items
        private String operatingHours;
    }

    @Data
    class MenuItem {
        private String id; // Unique identifier for the menu item
        private String name; // Name of the menu item
        private String description; // Description of the menu item
        private double price; // Price of the menu item
        private boolean available; // Whether the menu item is available
    }


