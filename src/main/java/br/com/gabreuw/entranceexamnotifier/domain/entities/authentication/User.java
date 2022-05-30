package br.com.gabreuw.entranceexamnotifier.domain.entities.authentication;

import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Email;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Identifier;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Name;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.value.objects.Password;
import br.com.gabreuw.entranceexamnotifier.shared.validation.SelfValidation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
public class User implements SelfValidation<User> {

    private Identifier id;

    @NotNull
    private Name name;

    @NotNull
    private Email email;

    @NotNull
    private Password password;

    public User(Identifier id, Name name, Email email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        validate(this);
    }

    public static User create(String name, String email, String password) {
        return new User(
                null,
                new Name(name),
                new Email(email),
                new Password(password)
        );
    }

    public boolean isValidPassword(String password) {
        return this.password.value().equals(password);
    }

}
