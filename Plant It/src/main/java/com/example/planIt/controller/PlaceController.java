package com.example.planIt.controller;

import com.example.planIt.model.Place;
import com.example.planIt.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
   PlaceService placeService;



    @GetMapping
    public List<Place> getAllPlaces(){
        return placeService.getAllPlaces();
    }


    @GetMapping("/{townName}")
    public List<Place> getByTown(@PathVariable String townName){
        return placeService.getByTownName(townName);
    }

    @GetMapping("/{townName}/{placeType}")
    public List<Place> getByTownAndType(@PathVariable String townName,
                                    @PathVariable String placeType){
        return placeService.getByTownAndType(townName,placeType);
        //return null;
    }

    @GetMapping("/ByUrl")
    public List<Place> getByUrl(@RequestParam String url,
                                @RequestParam String townName,
                                @RequestParam (required = false) String placeType){
        return placeService.getByUrl(url,townName,placeType);
    }

    @GetMapping("/ByRate")
    public List<Place> getByRate(@RequestParam String townName,
                                 @RequestParam (required = false) String placeType){

        return placeService.getByRate(townName,placeType);
    }
    @GetMapping("/ByPrice")
    public List<Place> getByPrice(@RequestParam String townName,
                                  @RequestParam (required = false) String placeType){
        return placeService.getByPrice(townName,placeType);
    }

//    @GetMapping
//    public List<Place> getPlaces(@RequestParam(required = false) String url,
//                                       @RequestParam (required = false) String townName,
//                                       @RequestParam(required = false) String placeType) {
//        return placeService.getPlace(url,townName,placeType);
////        if(townName!=null && url!=null && placeType==null)
////            return placeService.getSortedByTownAndUrl(url,townName);
////        else if(townName==null && placeType==null && url!=null)
////           return placeService.getByTownAndType(townName,placeType);
////        else if (townName!=null && url!=null && placeType!=null)
////            return placeService.getSortedByTown_typeAndUrl(townName,url,placeType);
////        else if (townName==null && url==null && placeType==null)
////            return placeService.getAllPlaces();
////        else if (townName!=null && url==null && placeType==null)
////            return placeService.getByTownName(townName);
////        else
////            return placeService.getSortedByTownAndRate(townName);
//    }
//    @GetMapping("/getSortedByRate")
//    public List<Place> getSortedByRate(){
//        return placeService.getSortedByRate();
//    }
//    @GetMapping("getSortedByPrice")
//    public List<Place> getSortedByPrice(){
//        return placeService.getSortedByPrice();
//    }
}
