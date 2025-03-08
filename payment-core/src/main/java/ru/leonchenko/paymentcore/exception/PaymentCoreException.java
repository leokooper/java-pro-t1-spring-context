package ru.leonchenko.paymentcore.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import ru.leonchenko.paymentcore.enums.PaymentCoreErrors;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Getter
@JsonIgnoreProperties({"status", "stackTrace", "suppressed", "localizedMessage", "cause"})
public class PaymentCoreException extends RuntimeException {

    private final HttpStatus status;
    private final String uuid;
    private final String time;
    private final String code;

    public PaymentCoreException(HttpStatus status, String uuid, String time, String code, String message, Throwable cause) {
        super(message, cause);
        this.status = status;
        this.uuid = uuid;
        this.time = time;
        this.code = code;
    }

    public PaymentCoreException(PaymentCoreErrors error) {
        this(error.getStatus(), UUID.randomUUID().toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now()), error.getCode(), error.getMessage(), null);
    }

    public PaymentCoreException(PaymentCoreErrors error, HttpStatusCode status) {
        this(HttpStatus.valueOf(status.value()), UUID.randomUUID().toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now()), error.getCode(), error.getMessage(), null);
    }

    public PaymentCoreException(PaymentCoreErrors error, String uuid) {
        this(error.getStatus(), uuid, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now()), error.getCode(), error.getMessage(), null);
    }

    public PaymentCoreException(PaymentCoreErrors error, Throwable ex) {
        this(error.getStatus(), UUID.randomUUID().toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now()), error.getCode(), error.getMessage(), ex.getCause());
    }

}