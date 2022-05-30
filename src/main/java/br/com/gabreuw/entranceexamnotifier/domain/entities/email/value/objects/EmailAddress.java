package br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record EmailAddress(@NotBlank String value) implements SelfValidation<EmailAddress> {

    public EmailAddress(@NotBlank String value) {
        this.value = value;
        validate(this);
    }

}
