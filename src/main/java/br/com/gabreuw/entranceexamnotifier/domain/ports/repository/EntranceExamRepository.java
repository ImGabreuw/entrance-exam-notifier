package br.com.gabreuw.entranceexamnotifier.domain.ports.repository;

import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.EntranceExam;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums.Course;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.CollegeName;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.value.objects.Price;
import br.com.gabreuw.entranceexamnotifier.shared.pagination.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EntranceExamRepository {

    Optional<EntranceExam> findByCollegeName(CollegeName collegeName);

    boolean existsByCollegeName(CollegeName collegeName);

    List<EntranceExam> findByCourses(Set<Course> courses, PageInfo pageInfo);

    List<EntranceExam> findByRegistrationDeadlineNearToReach(PageInfo pageInfo);

    List<EntranceExam> findByDivulgationDateNearToReach(PageInfo pageInfo);

    List<EntranceExam> findByMaximumPrice(Price price, PageInfo pageInfo);

    EntranceExam save(EntranceExam entranceExam);

}
