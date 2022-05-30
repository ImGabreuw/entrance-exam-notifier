package br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record Password(
        @NotBlank
        @Size(min = 8, max = 16)
        String value
) implements SelfValidation<Password> {

    public Password(String value) {
        this.value = value;
        validate(this);
    }

}
