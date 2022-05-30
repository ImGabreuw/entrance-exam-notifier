package br.com.gabreuw.entranceexamnotifier.domain.usecases.entrance.exam;

import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.EntranceExamRepository;
import br.com.gabreuw.entranceexamnotifier.domain.usecases.UseCase;

public record NotifyEntranceExamRegistrationDeadlineUseCase(
        EntranceExamRepository entranceExamRepository
) implements UseCase<NotifyEntranceExamRegistrationDeadlineUseCase.InputValues, NotifyEntranceExamRegistrationDeadlineUseCase.OutputValues> {

    @Override
    public NotifyEntranceExamRegistrationDeadlineUseCase.OutputValues execute(NotifyEntranceExamRegistrationDeadlineUseCase.InputValues input) {
        return null;
    }

    public record InputValues() implements UseCase.InputValues {
    }

    public record OutputValues() implements UseCase.OutputValues {
    }

}