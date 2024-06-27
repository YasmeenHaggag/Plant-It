package com.example.planIt.repository;
import com.example.planIt.model.Place;
import org.springframework.data.mongodb.repository.*;
import java.util.List;
public interface PlaceRepository extends MongoRepository<Place, String> {
    @Query("{ 'town' : ?0 }")
    List<Place> getByTownName(String townName);
}
