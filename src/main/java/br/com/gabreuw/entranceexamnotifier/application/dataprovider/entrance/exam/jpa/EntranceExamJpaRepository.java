package br.com.gabreuw.entranceexamnotifier.application.dataprovider.entrance.exam.jpa;

import br.com.gabreuw.entranceexamnotifier.application.dataprovider.entrance.exam.entity.EntranceExamEntity;
import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface EntranceExamJpaRepository extends JpaRepository<EntranceExamEntity, Long> {

    Optional<EntranceExamEntity> findByCollegeNameLikeIgnoreCase(String collegeName);

    boolean existsByCollegeNameIgnoreCase(String collegeName);

    @SuppressWarnings("SpringDataRepositoryMethodParametersInspection")
    Page<EntranceExamEntity> findAllByCoursesIn(Set<Course> courses, Pageable pageable);

    Page<EntranceExamEntity> findByRegistrationDeadlineIsAfter(LocalDate registrationDeadline, Pageable pageable);

    Page<EntranceExamEntity> findByDivulgationDateIsAfter(LocalDate divulgationDate, Pageable pageable);

    Page<EntranceExamEntity> findByPriceLessThanEqual(Double price, Pageable pageable);

}
