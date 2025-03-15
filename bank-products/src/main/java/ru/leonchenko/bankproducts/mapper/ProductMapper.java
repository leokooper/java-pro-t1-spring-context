package ru.leonchenko.bankproducts.mapper;

import ru.leonchenko.bankproducts.entity.Product;
import ru.leonchenko.models.bankproducts.product.get.ProductRsDto;
import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRsDto;

public class ProductMapper {

    public static ProductRsDto toDto(Product product) {
        return new ProductRsDto(
                product.getId(),
                product.getAccountNumber(),
                product.getBalance(),
                product.getProductType()
        );
    }

    public static UpdateBalanceRsDto toUpdateBalanceRsDto(Product product) {
        return new UpdateBalanceRsDto(
                product.getId(),
                product.getAccountNumber(),
                product.getBalance(),
                product.getProductType()
        );
    }
}