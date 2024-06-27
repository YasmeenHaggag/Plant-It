package com.example.planIt.repository;

import com.example.planIt.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
public interface PlansRepository extends MongoRepository<Plan,String> {
    @Query("{'user_id': ?0}")
    List<Plan> findPlansByUserId(String userId);
}
