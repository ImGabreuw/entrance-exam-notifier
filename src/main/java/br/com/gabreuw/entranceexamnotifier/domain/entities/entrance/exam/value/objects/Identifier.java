package br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotNull;

public record Identifier(@NotNull Long value) implements SelfValidation<Identifier> {

    public Identifier(Long value) {
        this.value = value;
        validate(this);
    }

}
