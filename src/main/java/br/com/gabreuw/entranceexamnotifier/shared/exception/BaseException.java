package br.com.gabreuw.entranceexamnotifier.shared.exception;

import br.com.gabreuw.entranceexamnotifier.shared.reflection.ReflectionHelper;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Object... values) {
        super(message.formatted(values));
    }

    public abstract int getStatusCode();

    public LocalDateTime getTimestamp() {
        return LocalDateTime.now();
    }

    public record Field(String name, Object value) {

        public static String formatFields(Class<?> clazz, Field... fields) {
            return Arrays.stream(fields)
                    .map(field -> ReflectionHelper.validateFieldName(clazz, field.name()) + "=" + field.value())
                    .collect(Collectors.joining(" and/or "));
        }

    }

}
