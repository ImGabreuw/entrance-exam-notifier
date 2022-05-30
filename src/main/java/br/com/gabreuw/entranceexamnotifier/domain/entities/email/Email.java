package br.com.gabreuw.entranceexamnotifier.domain.entities.email;

import br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects.EmailAddress;
import br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects.Subject;
import br.com.gabreuw.entranceexamnotifier.domain.entities.email.value.objects.Text;
import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Data
public class Email implements SelfValidation<Email> {

    @NotNull
    private EmailAddress from;

    @Size(min = 1)
    private Set<EmailAddress> to;

    @NotNull
    private Subject subject;

    @NotNull
    private Text text;

    @NoArgsConstructor(access = PRIVATE)
    @Getter
    public static class Builder {

        private EmailAddress from;

        private Set<EmailAddress> to;

        private Subject subject;

        private Text text;

        public static Builder builder() {
            return new Builder();
        }

        public Builder from(String from) {
            this.from = new EmailAddress(from);
            return this;
        }

        public Builder to(String... to) {
            this.to = Arrays.stream(to).map(EmailAddress::new).collect(Collectors.toSet());
            return this;
        }

        public Builder subject(String subject) {
            this.subject = new Subject(subject);
            return this;
        }

        public Builder text(String text) {
            this.text = new Text(text);
            return this;
        }

        public Email build() {
            return new Email(from, to, subject, text);
        }

    }

}
