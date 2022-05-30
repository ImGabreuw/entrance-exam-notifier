package br.com.gabreuw.entranceexamnotifier.shared.exception;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

public class AuthenticationException extends BaseException {

    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return UNAUTHORIZED.value();
    }

}
