package br.com.gabreuw.entranceexamnotifier.domain.usecases.authentication;

import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.UserMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.User;
import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.UserRepository;
import br.com.gabreuw.entranceexamnotifier.domain.usecases.UseCase;
import br.com.gabreuw.entranceexamnotifier.shared.exception.AuthenticationException;

import static br.com.gabreuw.entranceexamnotifier.shared.exception.MessageTemplate.EMAIL_IS_ALREADY_IN_USE_BY_OTHER_USER;

public record SignUpUseCase(
        UserRepository userRepository,
        UserMapper userMapper
) implements UseCase<SignUpUseCase.InputValues, SignUpUseCase.OutputValues> {

    @Override
    public SignUpUseCase.OutputValues execute(SignUpUseCase.InputValues input) {
        var name = input.name();
        var email = input.email();
        var password = input.password();

        if (userRepository.existsByEmail(email)) {
            throw new AuthenticationException(
                    EMAIL_IS_ALREADY_IN_USE_BY_OTHER_USER.format(email)
            );
        }

        var newUser = User.create(name, email, password);

        userRepository.save(newUser);

        // TODO: 28/05/2022 return JWT
        return null;
    }

    public record InputValues(String name, String email, String password) implements UseCase.InputValues {
    }

    public record OutputValues(String token) implements UseCase.OutputValues {
    }

}