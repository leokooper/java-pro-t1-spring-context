package ru.leonchenko.users.model.product;

import ru.leonchenko.users.enums.ProductType;

import java.math.BigDecimal;

public record ProductRsDto(
        Long id,
        String accountNumber,
        BigDecimal balance,
        ProductType productType) { }