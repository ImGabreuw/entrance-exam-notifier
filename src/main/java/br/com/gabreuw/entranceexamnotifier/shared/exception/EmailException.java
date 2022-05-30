package br.com.gabreuw.entranceexamnotifier.shared.exception;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

public class EmailException extends BaseException {

    public EmailException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return SERVICE_UNAVAILABLE.value();
    }

}
