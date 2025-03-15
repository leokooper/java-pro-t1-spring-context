package ru.leonchenko.paymentcore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.paymentcore.integration.BankProductsClient;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final BankProductsClient client;

    public List<ProductRsDto> getProductsByClient(Long id) {

        return client.getProductsByClient(id);
    }
}
