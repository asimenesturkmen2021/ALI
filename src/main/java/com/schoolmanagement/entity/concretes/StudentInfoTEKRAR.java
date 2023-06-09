package com.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.schoolmanagement.entity.enums.NoteTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfoTEKRAR {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Integer absentee;

    private Double midterExam;
    private Double finalExam;
    private Double examAverage;

    private String infoNote;

    @ManyToOne
    @JsonIgnoreProperties("teacherTEKRAR")
    private TeacherTEKRAR teacherTEKRAR;

    @ManyToOne
    private StudentTEKRAR studentTEKRAR;

    @Enumerated(EnumType.STRING)
    private NoteTEKRAR letterGrade;

    @ManyToOne
    @JsonIgnoreProperties("lessonTEKRAR")
    private LessonTEKRAR lessonTEKRAR;

    @OneToOne
    private EducationTermTEKRAR educationTermTEKRAR;













}
