package br.com.gabreuw.entranceexamnotifier.application.dataprovider.entrance.exam.entity;

import br.com.gabreuw.entranceexamnotifier.domain.entities.entrance.exam.enums.Course;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor
@Data
public class EntranceExamEntity {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String collegeName;

    @Enumerated(STRING)
    @ElementCollection
    private Set<Course> courses;

    @Column(nullable = false)
    private LocalDate registrationDeadline;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private LocalDate examDate;

    @Column(nullable = false)
    private String website;

    @Column(nullable = false)
    private LocalDate divulgationDate;

    public EntranceExamEntity(Long id, String collegeName, Set<Course> courses, LocalDate registrationDeadline, Double price, LocalDate examDate, String website, LocalDate divulgationDate) {
        this.id = id;
        this.collegeName = collegeName;
        this.courses = courses == null ? new HashSet<>() : courses;
        this.registrationDeadline = registrationDeadline;
        this.price = price;
        this.examDate = examDate;
        this.website = website;
        this.divulgationDate = divulgationDate;
    }

}
