package ie.atu.restraunt_service;

import lombok.Data;

import java.util.List;

@Data
public class RestrauntRequest {

    private String name;
    private String address;
    private String contactNumber;
    private List<String> cuisine;
    private OperatingHours operatingHours;
    private List<MenuItem> menu;

}
