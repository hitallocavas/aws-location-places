package io.github.hitallocavas.aws.location.places.controller;

import io.github.hitallocavas.aws.location.places.model.PlaceResponse;
import io.github.hitallocavas.aws.location.places.service.AWSLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.services.location.model.Place;

import java.util.List;

@RestController
@RequestMapping("places")
@RequiredArgsConstructor
public class LocationsController {

    private final AWSLocationService service;

    @GetMapping
    public List<PlaceResponse> findAllPlacesByLongitudeLatitude(@RequestParam Double longitude,
                                                                @RequestParam Double latitude){
        return service.findPlacesByLongitudeLatitude(longitude, latitude);
    }

}
