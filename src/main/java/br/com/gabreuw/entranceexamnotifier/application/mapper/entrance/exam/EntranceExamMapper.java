package br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam;

import br.com.gabreuw.entranceexamnotifier.application.dataprovider.entrance.exam.entity.EntranceExamEntity;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToApp;
import br.com.gabreuw.entranceexamnotifier.application.mapper.ToDomain;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.CollegeNameMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.EntranceExamIdentifierMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.PriceMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.annotations.WebsiteMapper;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods.CollegeNameMapperMethod;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods.EntranceExamIdentifierMapperMethod;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods.PriceMapperMethod;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.methods.WebsiteMapperMethod;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.EntranceExam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(
        componentModel = "spring",
        uses = {EntranceExamIdentifierMapperMethod.class, CollegeNameMapperMethod.class, PriceMapperMethod.class, WebsiteMapperMethod.class}
)
public interface EntranceExamMapper {

    @Mapping(target = "id", qualifiedBy = {EntranceExamIdentifierMapper.class, ToApp.class})
    @Mapping(target = "collegeName", qualifiedBy = {CollegeNameMapper.class, ToApp.class})
    @Mapping(target = "price", qualifiedBy = {PriceMapper.class, ToApp.class})
    @Mapping(target = "website", qualifiedBy = {WebsiteMapper.class, ToApp.class})
    EntranceExamEntity mapToApp(EntranceExam domain);

    @Mapping(target = "id", qualifiedBy = {EntranceExamIdentifierMapper.class, ToDomain.class})
    @Mapping(target = "collegeName", qualifiedBy = {CollegeNameMapper.class, ToDomain.class})
    @Mapping(target = "price", qualifiedBy = {PriceMapper.class, ToDomain.class})
    @Mapping(target = "website", qualifiedBy = {WebsiteMapper.class, ToDomain.class})
    EntranceExam mapToDomain(EntranceExamEntity app);

}
