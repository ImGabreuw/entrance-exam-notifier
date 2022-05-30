package br.com.gabreuw.entranceexamnotifier.shared.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MessageTemplate {

    DO_NOT_EXIST_ANY_USER_WITH_THIS_EMAIL("Do not exist any user with this email (%s).") {
        @Override
        public String format(Object... values) {
            return DO_NOT_EXIST_ANY_USER_WITH_THIS_EMAIL
                    .getMessage()
                    .formatted(values);
        }
    },
    INVALID_LOGIN_CREDENTIALS("Invalid email and/or password.") {
        @Override
        public String format(Object... values) {
            return DO_NOT_EXIST_ANY_USER_WITH_THIS_EMAIL.getMessage();
        }
    },
    EMAIL_IS_ALREADY_IN_USE_BY_OTHER_USER("Email (%s) is already in use by another user.") {
        @Override
        public String format(Object... values) {
            return DO_NOT_EXIST_ANY_USER_WITH_THIS_EMAIL.getMessage().formatted(values);
        }
    },
    COLLEGE_NAME_IS_ALREADY_IN_USE_BY_OTHER_ENTRANCE_EXAM("College name (%s) is already in use by another entrance exam.") {
        @Override
        public String format(Object... values) {
            return COLLEGE_NAME_IS_ALREADY_IN_USE_BY_OTHER_ENTRANCE_EXAM.getMessage().formatted(values);
        }
    },
    ERROR_SENDING_EMAIL("Error sending email to (%s). \nError message: %s") {
        @Override
        public String format(Object... values) {
            return ERROR_SENDING_EMAIL.getMessage().formatted(values);
        }
    };

    @Getter
    private final String message;

    public abstract String format(Object... values);

}
