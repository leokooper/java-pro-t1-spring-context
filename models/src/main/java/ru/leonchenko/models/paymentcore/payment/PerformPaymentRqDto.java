package ru.leonchenko.models.paymentcore.payment;

import ru.leonchenko.models.bankproducts.enums.ProductType;

import java.math.BigDecimal;

public record PerformPaymentRqDto(
        ProductType productType,
        BigDecimal paymentAmount
) { }
