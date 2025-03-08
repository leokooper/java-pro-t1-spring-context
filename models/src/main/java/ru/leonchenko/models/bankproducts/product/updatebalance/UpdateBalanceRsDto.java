package ru.leonchenko.models.bankproducts.product.updatebalance;

import ru.leonchenko.models.bankproducts.enums.ProductType;

import java.math.BigDecimal;

public record UpdateBalanceRsDto(Long id,
                                 String accountNumber,
                                 BigDecimal balance,
                                 ProductType productType) { }
