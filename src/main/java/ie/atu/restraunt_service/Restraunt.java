package ie.atu.restraunt_service;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Data
@Document(collection = "restaurants")
public class Restraunt {
    private String id;
    private String name;
    private String address;
    private String contactNumber;
    private List<String> cuisine;
    private float rating;
    private boolean isAvailable;
}
