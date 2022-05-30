package br.com.gabreuw.entranceexamnotifier.application.dataprovider.authentication.jpa;

import br.com.gabreuw.entranceexamnotifier.application.dataprovider.authentication.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    boolean existsByEmail(String email);

}
