package br.com.gabreuw.entranceexamnotifier.domain.usecases.entrance.exam;

import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.EntranceExam;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums.Course;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.CollegeName;
import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.EntranceExamRepository;
import br.com.gabreuw.entranceexamnotifier.domain.usecases.UseCase;
import br.com.gabreuw.entranceexamnotifier.shared.exception.InvalidInputException;

import java.time.LocalDate;
import java.util.Set;

import static br.com.gabreuw.entranceexamnotifier.shared.exception.MessageTemplate.COLLEGE_NAME_IS_ALREADY_IN_USE_BY_OTHER_ENTRANCE_EXAM;

public record RegisterEntranceExamUseCase(
        EntranceExamRepository entranceExamRepository
) implements UseCase<RegisterEntranceExamUseCase.InputValues, RegisterEntranceExamUseCase.OutputValues> {

    @Override
    public RegisterEntranceExamUseCase.OutputValues execute(RegisterEntranceExamUseCase.InputValues input) {
        var collegeName = input.collegeName();

        if (entranceExamRepository.existsByCollegeName(new CollegeName(collegeName))) {
            throw new InvalidInputException(
                    COLLEGE_NAME_IS_ALREADY_IN_USE_BY_OTHER_ENTRANCE_EXAM.format(collegeName)
            );
        }

        var courses = input.courses();
        var registrationDeadline = input.registrationDeadline();
        var price = input.price();
        var examDate = input.examDate();
        var website = input.website();
        var divulgationDate = input.divulgationDate();

        var entranceExam = EntranceExam.Builder
                .builder()
                .collegeName(collegeName)
                .courses(courses)
                .registrationDeadline(registrationDeadline)
                .price(price)
                .examDate(examDate)
                .website(website)
                .divulgationDate(divulgationDate)
                .build();

        return new OutputValues(
                entranceExamRepository.save(entranceExam)
        );
    }

    public record InputValues(
            String collegeName,
            Set<Course> courses,
            LocalDate registrationDeadline,
            Double price,
            LocalDate examDate,
            String website,
            LocalDate divulgationDate
    ) implements UseCase.InputValues {
    }

    public record OutputValues(EntranceExam entranceExam) implements UseCase.OutputValues {
    }

}