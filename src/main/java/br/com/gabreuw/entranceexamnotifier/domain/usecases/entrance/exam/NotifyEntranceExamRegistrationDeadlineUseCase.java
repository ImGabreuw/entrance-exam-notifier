package br.com.gabreuw.entranceexamnotifier.domain.usecases.entrance.exam;

import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.User;
import br.com.gabreuw.entranceexamnotifier.domain.entities.email.Email;
import br.com.gabreuw.entranceexamnotifier.domain.ports.email.EmailService;
import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.EntranceExamRepository;
import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.UserRepository;
import br.com.gabreuw.entranceexamnotifier.domain.usecases.UseCase;
import br.com.gabreuw.entranceexamnotifier.shared.date.DateHelper;
import br.com.gabreuw.entranceexamnotifier.shared.pagination.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

@Log4j2
public record NotifyEntranceExamRegistrationDeadlineUseCase(
        EntranceExamRepository entranceExamRepository,
        UserRepository userRepository,
        EmailService emailService,
        @Value("${spring.mail.username}")
        String sender
) implements UseCase<NotifyEntranceExamRegistrationDeadlineUseCase.InputValues, NotifyEntranceExamRegistrationDeadlineUseCase.OutputValues> {

    @Override
    public NotifyEntranceExamRegistrationDeadlineUseCase.OutputValues execute(NotifyEntranceExamRegistrationDeadlineUseCase.InputValues input) {
        var pageInfo = input.pageInfo();

        var entranceExamResult = entranceExamRepository.findByRegistrationDeadlineNearToReach(pageInfo);

        var emails = userRepository
                .findAll(pageInfo)
                .stream()
                .map(User::getEmail)
                .map(br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Email::value)
                .toArray(String[]::new);

        entranceExamResult.stream()
                .map(entranceExam -> Email.Builder
                        .builder()
                        .from(sender)
                        .to(emails)
                        .subject("Prazo de inscrição para a faculdade %s está acabando...".formatted(entranceExam.getCollegeName()))
                        .text(
                                """
                                O prazo de inscrição para %s é dia %s.
                                
                                Para realizar a sua inscrição acesse:
                                %s
                                """.formatted(entranceExam.getCollegeName(), DateHelper.format(entranceExam.getRegistrationDeadline()), entranceExam.getWebsite())
                        )
                        .build()
                )
                .forEach(emailService::send);

        log.info("{} users has been notified", emails.length);

        return new OutputValues();
    }

    public record InputValues(PageInfo pageInfo) implements UseCase.InputValues {
    }

    public record OutputValues() implements UseCase.OutputValues {
    }

}