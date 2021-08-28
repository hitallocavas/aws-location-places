package io.github.hitallocavas.aws.location.places.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.services.location.model.Place;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceResponse {
    private String label;
    private String city;
    private String country;
    private String postalCode;

    public static PlaceResponse of(Place place) {
        return builder()
                .label(place.label())
                .city(place.municipality())
                .country(place.country())
                .postalCode(place.postalCode())
                .build();
    }
}
