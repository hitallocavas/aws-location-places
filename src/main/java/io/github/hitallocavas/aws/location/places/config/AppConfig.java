package io.github.hitallocavas.aws.location.places.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class AppConfig {
    @Value("${AWS_LOCATION_INDEX_NAME}")
    private String awsLocationIndexName;

    @Value("${AWS_REGION_NAME}")
    private String awsRegionName;
}
