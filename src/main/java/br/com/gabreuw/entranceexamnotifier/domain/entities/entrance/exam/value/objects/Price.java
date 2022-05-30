package br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects;

import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public record Price(@PositiveOrZero @NotNull Double value) implements SelfValidation<Price> {

    public Price(Double value) {
        this.value = value;
        validate(this);
    }

    public boolean isFree() {
        return this.value == 0;
    }

}
