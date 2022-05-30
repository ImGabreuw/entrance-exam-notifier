package br.com.gabreuw.entranceexamnotifier.application.mapper.authentication.annotations;

import org.mapstruct.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Qualifier
@Target(TYPE)
@Retention(CLASS)
public @interface NameMapper {
}
