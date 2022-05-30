package br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Email(@NotBlank @javax.validation.constraints.Email String value) implements SelfValidation<Email> {

    public Email(@NotBlank @javax.validation.constraints.Email String value) {
        this.value = value;
        validate(this);
    }

}
