package br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;
import org.hibernate.validator.constraints.URL;

public record Website(@URL String url) implements SelfValidation<Website> {

    public Website(String url) {
        this.url = url;
        validate(this);
    }

}
