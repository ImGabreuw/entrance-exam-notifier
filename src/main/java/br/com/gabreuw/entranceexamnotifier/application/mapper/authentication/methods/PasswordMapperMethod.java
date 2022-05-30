package br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.PasswordMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Password;
import org.springframework.stereotype.Component;

@PasswordMapper
@Component
public class PasswordMapperMethod {

    @ToApp
    public String mapToApp(Password password) {
        return password.value();
    }

    @ToDomain
    public Password mapToDomain(String password) {
        return new Password(password);
    }

}
