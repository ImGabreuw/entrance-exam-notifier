package br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Name(@NotBlank String value) implements SelfValidation<Name> {

    public Name(@NotBlank String value) {
        this.value = value;
        validate(this);
    }

}
