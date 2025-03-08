package ru.leonchenko.bankproducts.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.leonchenko.bankproducts.exception.BankProductsException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static ru.leonchenko.bankproducts.enums.BankProductsErrors.COMMON_ERROR;

@ControllerAdvice
@Log4j2
public class BankProductsExceptionHandler {

    @ExceptionHandler(BankProductsException.class)
    public ResponseEntity<BankProductsException> handleAppExceptions(BankProductsException ex) {
        log.error("Уникальный идентификатор ошибки (UUID): " + ex.getUuid(), ex);
        return new ResponseEntity<>(ex, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BankProductsException> globalException(Exception ex) {
        var uuid = UUID.randomUUID().toString();
        log.error("Уникальный идентификатор ошибки (UUID): " + uuid, ex);
        return new ResponseEntity<>(new BankProductsException(COMMON_ERROR, uuid), INTERNAL_SERVER_ERROR);
    }
}
