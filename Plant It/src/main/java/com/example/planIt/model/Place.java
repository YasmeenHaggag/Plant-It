package com.example.planIt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "places")
public class Place {
    @Id
    @JsonIgnore
    private String id;
    private String name;
    //private String googleMapsUrl;
    @JsonIgnore
    private double lat;
    @JsonIgnore
    private double lon;
    @JsonIgnore
    private double distance;
    @JsonIgnore
    private String town;
    @JsonIgnore
    private double avgRate;
    @JsonIgnore
    private double avgPrice;
    @JsonIgnore
    private String type;
    @JsonIgnore
    private String reviews;
    private String imageCover;


}
