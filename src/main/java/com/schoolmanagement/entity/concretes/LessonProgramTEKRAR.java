package com.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolmanagement.entity.enums.DayTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonProgramTEKRAR implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayTEKRAR dayTEKRAR;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "US")
    private LocalTime startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm",timezone = "US")
    private LocalTime stopTime;

    @ManyToMany
    private Set<LessonTEKRAR>lessonTEKRARSet;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private EducationTermTEKRAR educationTermTEKRAR;

    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<TeacherTEKRAR> teacherTEKRARSet;

    @ManyToMany(mappedBy = "lessonProgramTEKRARSet",fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Set<StudentTEKRAR>studentTEKRARSet;

    @PreRemove
    private void removeLessonProgramFromStudentAndTeachers(){
        teacherTEKRARSet.forEach((t)->{
           // t.getLessonProgramTEKRARSet().remove(this);

        });
        studentTEKRARSet.forEach((s)->{
            s.getLessonProgramTEKRARSet().remove(this);
        });
    }
    }








