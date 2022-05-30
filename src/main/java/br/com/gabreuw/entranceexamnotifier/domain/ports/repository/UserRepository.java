package br.com.gabreuw.entranceexamnotifier.domain.ports.repository;

import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User save(User user);

}
