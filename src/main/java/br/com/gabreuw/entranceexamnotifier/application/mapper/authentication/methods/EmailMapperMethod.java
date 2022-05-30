package br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.EmailMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Email;
import org.springframework.stereotype.Component;

@EmailMapper
@Component
public class EmailMapperMethod {

    @ToApp
    public String mapToApp(Email email) {
        return email.value();
    }

    @ToDomain
    public Email mapToDomain(String email) {
        return new Email(email);
    }

}
