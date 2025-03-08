package ru.leonchenko.bankproducts.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@RequiredArgsConstructor
public enum BankProductsErrors {

    COMMON_ERROR(INTERNAL_SERVER_ERROR, "COMMON_ERROR", "Непредвиденная ошибка. Пожалуйста, повторите позже"),
    INTEGRATION_ERROR(INTERNAL_SERVER_ERROR, "INTEGRATION_ERROR", "При интеграционном вызове произошла ошибка");

    private final HttpStatus status;
    private final String code;
    private final String message;
}