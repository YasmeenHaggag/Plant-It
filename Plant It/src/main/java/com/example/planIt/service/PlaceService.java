package com.example.planIt.service;

import com.example.planIt.model.Place;
import com.example.planIt.repository.PlaceRepository;
import com.example.planIt.util.GoogleMapsUrlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;


    public List<Place> getByUrl(String url,String townName,String placeType){
        List<Place> filteredPlaces= getSortedNearbyPlaces(url);
        filteredPlaces=filterPlacesByTown(filteredPlaces,townName);
        if(placeType != null && !placeType.isEmpty()){
            filteredPlaces=filterPlacesByType(filteredPlaces,placeType);
        }
        return filteredPlaces;
    }


    public List<Place> getSortedNearbyPlaces(String googleMapsUrl) {
        double[] coordinates = GoogleMapsUrlParser.extractCoordinates(googleMapsUrl);
        double lat = coordinates[0];
        double lon = coordinates[1];

        List<Place> places = placeRepository.findAll();
        places.forEach(place -> place.setDistance(calculateDistance(lat, lon, place.getLat(), place.getLon())));

        Collections.sort(places, Comparator.comparingDouble(Place::getDistance));
        return places;

    }
    public List<Place> getSortedByTownAndUrl(String url,String town){
       List<Place> sortedByUrl= getSortedNearbyPlaces(url);
       return filterPlacesByTown(sortedByUrl,town);
    }
   public List<Place> filterPlacesByTown(List<Place> places, String townName) {
    return places.stream()
            .filter(place -> townName.equals(place.getTown()))
            .collect(Collectors.toList());
    }
    public List<Place> getByRate(String townName,String placeType){
        List<Place> filteredPlaces=placeRepository.getByTownName(townName);
        Collections.sort(filteredPlaces,Comparator.comparingDouble(Place::getAvgRate));
        if(placeType != null && !placeType.isEmpty())
            filteredPlaces = filterPlacesByType(filteredPlaces,placeType);
        return filteredPlaces;
//        return filterPlacesByTown(sortedByRate,townName);
    }
    public List<Place> getByPrice(String townName,String placeType){
        List<Place> filtredPlaces=getByTownName(townName);
        Collections.sort(filtredPlaces,Comparator.comparingDouble(Place::getAvgPrice));
        if(placeType != null && !placeType.isEmpty())
            filtredPlaces=filterPlacesByType(filtredPlaces,placeType);
        return filtredPlaces;
    }
    public List<Place> filterPlacesByType(List<Place> places, String placeType) {
        return places.stream()
                .filter(place -> placeType.equals(place.getType()))
                .collect(Collectors.toList());
    }

    public List<Place> getByTownAndType(String townName,String placeType){
        List<Place> sortedByTown=getByTownName(townName);
        return filterPlacesByType(sortedByTown,placeType);
    }
    public List<Place> getSortedByTown_typeAndUrl(String townName,String url,String placeType){
        List<Place> sortedPlaces=getSortedNearbyPlaces(url);
        sortedPlaces= filterPlacesByType(sortedPlaces,placeType);
        return filterPlacesByTown(sortedPlaces,townName);
    }
    public List<Place> getSortedByTownAndRate(String townName,String placeType){
        List<Place> filteredPlaces=getByTownAndType(townName,placeType);
        Collections.sort(filteredPlaces,Comparator.comparingDouble(Place::getAvgRate));
        return filteredPlaces;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }
    public List<Place> getAllPlaces(){
        return placeRepository.findAll();
    }
    public List<Place> getByTownName(String townName){
        return placeRepository.getByTownName(townName);
    }

    public List<Place> getPlace(String url,String townName,String placeType)
        {
            if (townName!=null && url==null && placeType==null)
                return this.getByTownName(townName);
            else if(townName!=null && url!=null && placeType==null)
                return this.getSortedByTownAndUrl(url,townName);
            else if (townName!=null && url!=null && placeType!=null)
                return this.getSortedByTown_typeAndUrl(townName,url,placeType);
            else
                return null ;
        }

}
