package ie.atu.restraunt_service;

import lombok.Data;

@Data
public class Review {
    private String reviewId;
    private String customerId;
    private String comment;
    private float rating;
}
