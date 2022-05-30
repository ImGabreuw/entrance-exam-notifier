package br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.UserIdentifierMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Identifier;
import org.springframework.stereotype.Component;

@UserIdentifierMapper
@Component
public class UserIdentifierMapperMethod {

    @ToApp
    public Long mapToApp(Identifier id) {
        return id.value();
    }

    @ToDomain
    public Identifier mapToDomain(Long id) {
        return new Identifier(id);
    }

}
