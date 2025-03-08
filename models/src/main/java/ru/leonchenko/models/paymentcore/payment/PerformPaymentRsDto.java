package ru.leonchenko.models.paymentcore.payment;

import ru.leonchenko.models.bankproducts.enums.ProductType;

import java.math.BigDecimal;

public record PerformPaymentRsDto(
        ProductType productType,
        String accountNumber,
        BigDecimal accountBalance
) { }
