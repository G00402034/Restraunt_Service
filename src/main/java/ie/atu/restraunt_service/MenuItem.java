package ie.atu.restraunt_service;

import lombok.Data;

@Data
public class MenuItem {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private boolean isAvailable;
}
