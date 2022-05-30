package br.com.gabreuw.entranceexamnotifier.shared.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class InvalidInputException extends BaseException {

    public InvalidInputException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return BAD_REQUEST.value();
    }

}
