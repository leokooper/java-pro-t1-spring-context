package ru.leonchenko.paymentcore.endpoint;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.leonchenko.models.paymentcore.payment.PerformPaymentRqDto;
import ru.leonchenko.models.paymentcore.payment.PerformPaymentRsDto;
import ru.leonchenko.paymentcore.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PutMapping("/clients/{id}")
    public PerformPaymentRsDto performPayment(
            @PathVariable Long id,
            @RequestBody PerformPaymentRqDto rq) {
        return paymentService.performPayment(id, rq);
    }
}
