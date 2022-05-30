package br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.NameMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Name;
import org.springframework.stereotype.Component;

@NameMapper
@Component
public class NameMapperMethod {

    @ToApp
    public String mapToApp(Name name) {
        return name.value();
    }

    @ToDomain
    public Name mapToDomain(String name) {
        return new Name(name);
    }

}
