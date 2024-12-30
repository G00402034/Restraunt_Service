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
        private String cuisine;
        private List<MenuItem> menu;
        private String operatingHours;
    }

    @Data
    class MenuItem {
        private String id;
        private String name;
        private String description;
        private double price;
        private boolean available;
    }


