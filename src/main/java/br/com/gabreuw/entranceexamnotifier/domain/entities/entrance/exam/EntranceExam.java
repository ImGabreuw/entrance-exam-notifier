package br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam;

import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums.Course;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.CollegeName;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Identifier;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Price;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Website;
import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@Data
public class EntranceExam implements SelfValidation<EntranceExam> {


    private Identifier id;

    @NotNull
    private CollegeName collegeName;

    @Size(min = 1)
    private Set<Course> courses;

    @NotNull
    private LocalDate registrationDeadline;

    @NotNull
    private Price price;

    @NotNull
    private LocalDate examDate;

    @NotNull
    private Website website;

    @NotNull
    private LocalDate divulgationDate;

    public EntranceExam(Identifier id, CollegeName collegeName, Set<Course> courses, LocalDate registrationDeadline, Price price, LocalDate examDate, Website website, LocalDate divulgationDate) {
        this.id = id;
        this.collegeName = collegeName;
        this.courses = courses == null ? new HashSet<>() : courses;
        this.registrationDeadline = registrationDeadline;
        this.price = price;
        this.examDate = examDate;
        this.website = website;
        this.divulgationDate = divulgationDate;
        validate(this);
    }

    public long remainingDaysToRegistrationDeadline() {
        var today = LocalDate.now();

        return ChronoUnit.DAYS.between(today, this.registrationDeadline);
    }

    public long remainingDaysToExanDate() {
        var today = LocalDate.now();

        return ChronoUnit.DAYS.between(today, this.examDate);
    }

    public long remainingDaysToDivulgationDate() {
        var today = LocalDate.now();

        return ChronoUnit.DAYS.between(today, this.divulgationDate);
    }

    @NoArgsConstructor(access = PRIVATE)
    @Getter
    public static class Builder {


        private Identifier id;

        private CollegeName collegeName;

        private Set<Course> courses;

        private LocalDate registrationDeadline;

        private Price price;

        private LocalDate examDate;

        private Website website;

        private LocalDate divulgationDate;

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Identifier id) {
            this.id = id;
            return this;
        }

        public Builder id(Long id) {
            this.id = new Identifier(id);
            return this;
        }

        public Builder collegeName(CollegeName collegeName) {
            this.collegeName = collegeName;
            return this;
        }

        public Builder collegeName(String collegeName) {
            this.collegeName = new CollegeName(collegeName);
            return this;
        }

        public Builder courses(Set<Course> courses) {
            this.courses = courses;
            return this;
        }

        public Builder courses(Course... courses) {
            this.courses = new HashSet<>(Arrays.asList(courses));
            return this;
        }

        public Builder registrationDeadline(LocalDate registrationDeadline) {
            this.registrationDeadline = registrationDeadline;
            return this;
        }

        public Builder price(Price price) {
            this.price = price;
            return this;
        }

        public Builder price(Double price) {
            this.price = new Price(price);
            return this;
        }

        public Builder examDate(LocalDate examDate) {
            this.examDate = examDate;
            return this;
        }

        public Builder website(Website website) {
            this.website = website;
            return this;
        }

        public Builder website(String website) {
            this.website = new Website(website);
            return this;
        }

        public Builder divulgationDate(LocalDate divulgationDate) {
            this.divulgationDate = divulgationDate;
            return this;
        }

        public EntranceExam build() {
            return new EntranceExam(id, collegeName, courses, registrationDeadline, price, examDate, website, divulgationDate);
        }

    }

}
