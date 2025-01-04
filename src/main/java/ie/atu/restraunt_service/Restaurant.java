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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getCuisine() {
            return cuisine;
        }

        public void setCuisine(String cuisine) {
            this.cuisine = cuisine;
        }

        public List<MenuItem> getMenu() {
            return menu;
        }

        public void setMenu(List<MenuItem> menu) {
            this.menu = menu;
        }

        public String getOperatingHours() {
            return operatingHours;
        }

        public void setOperatingHours(String operatingHours) {
            this.operatingHours = operatingHours;
        }
    }

    @Data
    class MenuItem {
        private String id;
        private String name;
        private String description;
        private double price;
        private boolean available;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public boolean isAvailable() {
            return available;
        }

        public void setAvailable(boolean available) {
            this.available = available;
        }
    }


