package br.com.gabreuw.entranceexamnotifier.application.mapper.authentication;

import br.com.gabreuw.entranceexamnotifier.application.dataprovider.authentication.entity.UserEntity;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.EmailMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.UserIdentifierMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.NameMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations.PasswordMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods.EmailMapperMethod;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods.UserIdentifierMapperMethod;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods.NameMapperMethod;
import br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.methods.PasswordMapperMethod;
import br.com.gabreuw.entranceexamnotifier.domain.entities.authentication.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        uses = {UserIdentifierMapperMethod.class, NameMapperMethod.class, EmailMapperMethod.class, PasswordMapperMethod.class}
)
public interface UserMapper {

    @Mapping(target = "id", qualifiedBy = {UserIdentifierMapper.class, ToApp.class})
    @Mapping(target = "name", qualifiedBy = {NameMapper.class, ToApp.class})
    @Mapping(target = "email", qualifiedBy = {EmailMapper.class, ToApp.class})
    @Mapping(target = "password", qualifiedBy = {PasswordMapper.class, ToApp.class})
    UserEntity toApp(User domain);

    @Mapping(target = "id", qualifiedBy = {UserIdentifierMapper.class, ToDomain.class})
    @Mapping(target = "name", qualifiedBy = {NameMapper.class, ToDomain.class})
    @Mapping(target = "email", qualifiedBy = {EmailMapper.class, ToDomain.class})
    @Mapping(target = "password", qualifiedBy = {PasswordMapper.class, ToDomain.class})
    User toDomain(UserEntity app);

}
