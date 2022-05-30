package br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods;

import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.CollegeNameMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.CollegeName;
import org.springframework.stereotype.Component;

@CollegeNameMapper
@Component
public class CollegeNameMapperMethod {

    @ToApp
    public String mapToApp(CollegeName collegeName) {
        return collegeName.value();
    }

    @ToDomain
    public CollegeName mapToDomain(String collegeName) {
        return new CollegeName(collegeName);
    }

}
