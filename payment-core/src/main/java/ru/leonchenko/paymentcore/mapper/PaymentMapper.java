package ru.leonchenko.paymentcore.mapper;

import ru.leonchenko.models.bankproducts.product.updatebalance.UpdateBalanceRsDto;
import ru.leonchenko.models.paymentcore.payment.PerformPaymentRsDto;

public class PaymentMapper {

    public static PerformPaymentRsDto toPerformPaymentRsDto(UpdateBalanceRsDto updateBalance) {
        return new PerformPaymentRsDto(
                updateBalance.productType(),
                updateBalance.accountNumber(),
                updateBalance.balance()
        );
    }
}