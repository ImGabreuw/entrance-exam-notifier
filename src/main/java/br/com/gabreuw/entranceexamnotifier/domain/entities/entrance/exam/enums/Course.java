package br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Course {

    COMPUTER_SCIENCE("ciência da computação");

    @Getter
    private final String description;

}
