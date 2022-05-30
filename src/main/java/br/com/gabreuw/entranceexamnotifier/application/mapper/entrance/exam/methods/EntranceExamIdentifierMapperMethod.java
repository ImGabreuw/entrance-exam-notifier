package br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.EntranceExamIdentifierMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Identifier;
import org.springframework.stereotype.Component;

@EntranceExamIdentifierMapper
@Component
public class EntranceExamIdentifierMapperMethod {

    @ToApp
    public Long mapToApp(Identifier id) {
        return id.value();
    }

    @ToDomain
    public Identifier mapToDomain(Long id) {
        return new Identifier(id);
    }

}
