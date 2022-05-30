package br.com.gabreuw.entranceexamnotifier.application.mailer;

import br.com.gabreuw.entranceexamnotifier.domain.entities.email.Email;
import br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects.EmailAddress;
import br.com.gabreuw.entranceexamnotifier.domain.ports.email.EmailService;
import br.com.gabreuw.entranceexamnotifier.shared.exception.EmailException;
import br.com.gabreuw.entranceexamnotifier.shared.exception.MessageTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public record JavaMailer(
        JavaMailSender javaMailSender
) implements EmailService {

    @Override
    public void send(Email email) {
        var mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(email.getFrom().value());
        String[] to = email.getTo().stream().map(EmailAddress::value).toArray(String[]::new);
        mailMessage.setTo(to);
        mailMessage.setSubject(email.getSubject().value());
        mailMessage.setText(email.getText().value());

        try {
            javaMailSender.send(mailMessage);
        } catch (MailException exception) {
            String message = MessageTemplate.ERROR_SENDING_EMAIL.format(
                    String.join(",", to),
                    exception.getMessage()
            );
            log.error(message);
            throw new EmailException(message);
        }
    }

}
