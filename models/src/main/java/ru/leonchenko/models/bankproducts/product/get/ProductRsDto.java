package ru.leonchenko.models.bankproducts.product.get;

import ru.leonchenko.models.bankproducts.enums.ProductType;

import java.math.BigDecimal;

public record ProductRsDto(
        Long id,
        String accountNumber,
        BigDecimal balance,
        ProductType productType) { }