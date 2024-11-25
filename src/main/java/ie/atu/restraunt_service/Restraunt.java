package ie.atu.restraunt_service;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "restaurants")
public class Restraunt
{
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private List<String> cuisine;
    private OperatingHours operatingHours;
    private List<MenuItem> menu;
    private float rating;
    private boolean isAvailable;
    private List<Review> reviews;
}
class OperatingHours
{
    private String openingTime;
    private String closingTime;
}