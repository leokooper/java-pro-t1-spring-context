package ru.leonchenko.bankproducts.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

@ConfigurationProperties(prefix = "client")
public record ClientProperties(
        BaseUrl baseUrl,
        Timeout timeout
){
    public record BaseUrl(String paymentCore) { }

    public record Timeout(Duration connection, Duration read) { }
}