package br.com.gabreuw.entranceexamnotifier.domain.usecases.authentication;

import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.UserRepository;
import br.com.gabreuw.entranceexamnotifier.domain.usecases.UseCase;
import br.com.gabreuw.entranceexamnotifier.shared.exception.InvalidInputException;
import br.com.gabreuw.entranceexamnotifier.shared.exception.AuthenticationException;

import static br.com.gabreuw.entranceexamnotifier.shared.exception.MessageTemplate.DO_NOT_EXIST_ANY_USER_WITH_THIS_EMAIL;
import static br.com.gabreuw.entranceexamnotifier.shared.exception.MessageTemplate.INVALID_LOGIN_CREDENTIALS;

public record SignInUseCase(
        UserRepository userRepository
) implements UseCase<SignInUseCase.InputValues, SignInUseCase.OutputValues> {

    @Override
    public SignInUseCase.OutputValues execute(SignInUseCase.InputValues input) {
        var email = input.email();

        var user = userRepository
                .findByEmail(email)
                .orElseThrow(() -> new InvalidInputException(
                        DO_NOT_EXIST_ANY_USER_WITH_THIS_EMAIL.format(email)
                ));

        var password = input.password();

        if (!user.isValidPassword(password)) {
            throw new AuthenticationException(
                    INVALID_LOGIN_CREDENTIALS.getMessage()
            );
        }

        // TODO: 28/05/2022 return JWT
        return null;
    }

    public record InputValues(String email, String password) implements UseCase.InputValues {
    }

    public record OutputValues(String token) implements UseCase.OutputValues {
    }

}