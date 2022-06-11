package br.com.gabreuw.entranceexamnotifier.domain.ports.repository;

import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.User;
import br.com.gabreuw.entranceexamnotifier.shared.pagination.PageInfo;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll(PageInfo pageInfo);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User save(User user);

}
