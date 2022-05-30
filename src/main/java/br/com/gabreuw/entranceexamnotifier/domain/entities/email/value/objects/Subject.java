package br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Subject(@NotBlank String value) implements SelfValidation<Subject> {

    public Subject(String value) {
        this.value = value;
        validate(this);
    }

}
