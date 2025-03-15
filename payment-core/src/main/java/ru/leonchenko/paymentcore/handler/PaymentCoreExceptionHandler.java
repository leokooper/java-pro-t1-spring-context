package ru.leonchenko.paymentcore.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.leonchenko.paymentcore.exception.PaymentCoreException;
import ru.leonchenko.paymentcore.enums.PaymentCoreErrors;

import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Log4j2
public class PaymentCoreExceptionHandler {

    @ExceptionHandler(PaymentCoreException.class)
    public ResponseEntity<PaymentCoreException> handleAppExceptions(PaymentCoreException ex) {
        log.error("Уникальный идентификатор ошибки (UUID): " + ex.getUuid(), ex);
        return new ResponseEntity<>(ex, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<PaymentCoreException> globalException(Exception ex) {
        var uuid = UUID.randomUUID().toString();
        log.error("Уникальный идентификатор ошибки (UUID): " + uuid, ex);
        return new ResponseEntity<>(new PaymentCoreException(PaymentCoreErrors.COMMON_ERROR, uuid), INTERNAL_SERVER_ERROR);
    }
}
