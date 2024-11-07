package ie.atu.restraunt_service;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestrauntRepository extends MongoRepository<Restraunt, String> {
}
