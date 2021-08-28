package io.github.hitallocavas.aws.location.places.providers;

import io.github.hitallocavas.aws.location.places.config.AppConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.location.LocationClient;

@Configuration
@RequiredArgsConstructor
public class AWSProviders {

    private final AppConfig appConfig;

    @Bean
    public EnvironmentVariableCredentialsProvider environmentVariableCredentialsProvider(){
        return EnvironmentVariableCredentialsProvider
                .create();
    }

    @Bean
    public LocationClient locationClientProvider(EnvironmentVariableCredentialsProvider environmentVariableCredentialsProvider){
        return LocationClient.builder()
                .region(Region.of(appConfig.getAwsRegionName()))
                .credentialsProvider(environmentVariableCredentialsProvider)
                .build();
    }
}
