package br.com.gabreuw.entranceexamnotifier.application.dataprovider.authentication.repository;

import br.com.gabreuw.entranceexamnotifier.application.dataprovider.authentication.entity.UserEntity;
import br.com.gabreuw.entranceexamnotifier.application.dataprovider.authentication.jpa.UserJpaRepository;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.UserMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.User;
import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.UserRepository;
import br.com.gabreuw.entranceexamnotifier.shared.pagination.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll(PageInfo pageInfo) {
        var page = pageInfo
                .toPageRequest()
                .withSort(Sort.by("name").ascending());

        return userJpaRepository
                .findAll(page)
                .map(userMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository
                .findByEmail(email)
                .map(userMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        UserEntity savedUser = userJpaRepository.save(
                userMapper.toApp(user)
        );

        return userMapper.toDomain(savedUser);
    }

}
