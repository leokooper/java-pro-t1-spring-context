package ru.leonchenko.users.mapper;

import ru.leonchenko.users.entity.Product;
import ru.leonchenko.users.model.product.ProductRsDto;

public class ProductMapper {

    public static ProductRsDto toDto(Product product) {
        return new ProductRsDto(
                product.getId(),
                product.getAccountNumber(),
                product.getBalance(),
                product.getProductType()
        );
    }
}