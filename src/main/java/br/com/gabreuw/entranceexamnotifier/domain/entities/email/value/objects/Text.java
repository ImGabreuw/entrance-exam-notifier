package br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record Text(@NotBlank String value) implements SelfValidation<Text> {

    public Text(String value) {
        this.value = value;
        validate(this);
    }

}
