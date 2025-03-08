package ru.leonchenko.bankproducts.config;

import lombok.NonNull;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestClient;
import ru.leonchenko.bankproducts.config.properties.ClientProperties;
import ru.leonchenko.bankproducts.exception.BankProductsException;

import java.io.IOException;

import static ru.leonchenko.bankproducts.enums.BankProductsErrors.INTEGRATION_ERROR;

@Configuration
public class RestClientConfig {

    @Bean
    public DefaultResponseErrorHandler customErrorHandler()  {
        return new DefaultResponseErrorHandler() {

            @Override
            public boolean hasError(@NonNull ClientHttpResponse response) throws IOException {
                return response.getStatusCode().is5xxServerError() ||
                        response.getStatusCode().is4xxClientError();
            }

            @Override
            public void handleError(@NonNull ClientHttpResponse response) throws IOException, BankProductsException {
                System.out.printf("Status code: %s", response.getStatusCode().value());
                throw new BankProductsException(INTEGRATION_ERROR, response.getStatusCode());
            }
        };
    }

    @Bean
    public RestClient restClient(
            RestTemplateBuilder restTemplateBuilder,
            DefaultResponseErrorHandler customErrorHandler,
            ClientProperties clientProperties
    ) {

        var restTemplate = restTemplateBuilder
                .connectTimeout(clientProperties.timeout().connection())
                .readTimeout(clientProperties.timeout().read())
                .errorHandler(customErrorHandler)
                .build();

        return RestClient
                .builder(restTemplate)
                .baseUrl(clientProperties.baseUrl().paymentCore())
                .build();
    }
}
