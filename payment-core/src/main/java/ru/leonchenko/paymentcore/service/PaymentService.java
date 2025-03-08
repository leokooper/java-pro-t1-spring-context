package ru.leonchenko.paymentcore.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import ru.leonchenko.models.paymentcore.payment.PerformPaymentRqDto;
import ru.leonchenko.models.paymentcore.payment.PerformPaymentRsDto;
import ru.leonchenko.paymentcore.exception.PaymentCoreException;
import ru.leonchenko.paymentcore.integration.BankProductsClient;
import ru.leonchenko.paymentcore.mapper.PaymentMapper;


import static ru.leonchenko.paymentcore.enums.PaymentCoreErrors.NOT_ENOUGH_BALANCE_ERROR;
import static ru.leonchenko.paymentcore.enums.PaymentCoreErrors.PRODUCT_NOT_FOUND_ERROR;


@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final BankProductsClient client;

    public PerformPaymentRsDto performPayment(Long id, PerformPaymentRqDto rq) {

        val productRs = client.getProductsByClient(id).stream()
                .filter(product -> rq.productType().equals(product.productType()))
                .findFirst()
                .orElseThrow(() -> new PaymentCoreException(PRODUCT_NOT_FOUND_ERROR));

        val balance = productRs.balance();

        val isEnoughBalance = balance.compareTo(rq.paymentAmount()) > 0
                || balance.compareTo(rq.paymentAmount()) == 0;

        if (!isEnoughBalance){
            throw new PaymentCoreException(NOT_ENOUGH_BALANCE_ERROR);
        }

        val response = client.performPayment(productRs.id(), rq);

        return PaymentMapper.toPerformPaymentRsDto(response);
    }
}
