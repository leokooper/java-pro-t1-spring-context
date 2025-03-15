package ru.leonchenko.paymentcore.integration;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRqDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRsDto;
import ru.leonchenko.models.paymentcore.payment.PerformPaymentRqDto;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BankProductsClient {

    private final RestClient restClient;

    public List<ProductRsDto> getProductsByClient(Long id){
        return restClient.get()
                .uri("/api/v1/users/" + id + "/products")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public UpdateBalanceRsDto performPayment(Long id, PerformPaymentRqDto rq){

        val request = new UpdateBalanceRqDto(rq.paymentAmount());

        return restClient.put()
                .uri("/api/v1/products/" + id)
                .body(request)
                .retrieve()
                .body(UpdateBalanceRsDto.class);
    }
}
