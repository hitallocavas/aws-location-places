package io.github.hitallocavas.aws.location.places.service;

import io.github.hitallocavas.aws.location.places.config.AppConfig;
import io.github.hitallocavas.aws.location.places.model.PlaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.location.LocationClient;
import software.amazon.awssdk.services.location.model.Place;
import software.amazon.awssdk.services.location.model.SearchForPositionResult;
import software.amazon.awssdk.services.location.model.SearchPlaceIndexForPositionRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AWSLocationService {

    private final LocationClient locationClient;
    private final AppConfig appConfig;

    public List<PlaceResponse> findPlacesByLongitudeLatitude(Double longitude, Double latitude) {
        var request = SearchPlaceIndexForPositionRequest.builder()
                .position(longitude, latitude)
                .indexName(appConfig.getAwsLocationIndexName())
                .maxResults(10)
                .build();

        return locationClient
                .searchPlaceIndexForPosition(request)
                .results()
                .stream()
                .map(SearchForPositionResult::place)
                .map(PlaceResponse::of)
                .collect(Collectors.toList());
    }

}
