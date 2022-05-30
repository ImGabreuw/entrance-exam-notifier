package br.com.gabreuw.entranceexamnotifier.application.dataprovider.entrance.exam.repository;

import br.com.gabreuw.entranceexamnotifier.application.dataprovider.entrance.exam.jpa.EntranceExamJpaRepository;
import br.com.gabreuw.entranceexamnotifier.application.mapper.entrance.exam.EntranceExamMapper;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.EntranceExam;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums.Course;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.CollegeName;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Price;
import br.com.gabreuw.entranceexamnotifier.domain.ports.repository.EntranceExamRepository;
import br.com.gabreuw.entranceexamnotifier.shared.pagination.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class EntranceExamRepositoryImpl implements EntranceExamRepository {

    private final EntranceExamJpaRepository entranceExamJpaRepository;
    private final EntranceExamMapper entranceExamMapper;

    @Override
    public Optional<EntranceExam> findByCollegeName(CollegeName collegeName) {
        return entranceExamJpaRepository
                .findByCollegeNameLikeIgnoreCase(collegeName.value())
                .map(entranceExamMapper::mapToDomain);
    }

    @Override
    public boolean existsByCollegeName(CollegeName collegeName) {
        return entranceExamJpaRepository.existsByCollegeNameIgnoreCase(collegeName.value());
    }

    @Override
    public List<EntranceExam> findByCourses(Set<Course> courses, PageInfo pageInfo) {
        var page = pageInfo.toSortedPageRequest();

        return entranceExamJpaRepository
                .findAllByCoursesIn(courses, page)
                .map(entranceExamMapper::mapToDomain)
                .getContent();
    }

    @Override
    public List<EntranceExam> findByRegistrationDeadlineNearToReach(PageInfo pageInfo) {
        var page = pageInfo
                .toSortedPageRequest()
                .withSort(Sort.by("registrationDeadline").ascending());

        return entranceExamJpaRepository
                .findByRegistrationDeadlineIsAfter(LocalDate.now(), page)
                .map(entranceExamMapper::mapToDomain)
                .getContent();
    }

    @Override
    public List<EntranceExam> findByDivulgationDateNearToReach(PageInfo pageInfo) {
        var page = pageInfo
                .toSortedPageRequest()
                .withSort(Sort.by("divulgationDate").ascending());

        return entranceExamJpaRepository
                .findByDivulgationDateIsAfter(LocalDate.now(), page)
                .map(entranceExamMapper::mapToDomain)
                .getContent();
    }

    @Override
    public List<EntranceExam> findByMaximumPrice(Price price, PageInfo pageInfo) {
        var page = pageInfo
                .toSortedPageRequest()
                .withSort(Sort.by("price").ascending());

        return entranceExamJpaRepository
                .findByPriceLessThanEqual(price.value(), page)
                .map(entranceExamMapper::mapToDomain)
                .getContent();
    }

    @Override
    public EntranceExam save(EntranceExam entranceExam) {
        var entranceExamEntity = entranceExamMapper.mapToApp(entranceExam);

        return entranceExamMapper.mapToDomain(
                entranceExamJpaRepository.save(entranceExamEntity)
        );
    }

}
