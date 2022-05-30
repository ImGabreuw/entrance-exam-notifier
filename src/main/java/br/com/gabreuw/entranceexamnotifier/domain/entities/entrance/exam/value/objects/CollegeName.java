package br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotBlank;

public record CollegeName(@NotBlank String value) implements SelfValidation<CollegeName> {

    public CollegeName(String value) {
        this.value = value;
        validate(this);
    }

}
