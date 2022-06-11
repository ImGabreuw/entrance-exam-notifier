package br.com.gabreuw.entranceexamnotifier.shared.date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static br.com.gabreuw.entranceexamnotifier.shared.date.DateHelper.DateTimeTemplates.DATE;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class DateHelper {

    @RequiredArgsConstructor
    enum DateTimeTemplates {
        DATE(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        @Getter
        private final DateTimeFormatter template;
    }

    public static String format(LocalDate localDate) {
        return DATE.getTemplate().format(localDate);
    }

}
