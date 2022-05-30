package br.com.gabreuw.entranceexamnotifier.domain.ports.email;

import br.com.gabreuw.entranceexamnotifier.domain.entities.email.Email;

public interface EmailService {

    void send(Email email);

}
