package com.schoolmanagement.entity.concretes;

import com.schoolmanagement.entity.abstracts.UserTEKRAR;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true,onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class TeacherTEKRAR extends UserTEKRAR {

@OneToOne(mappedBy = "teacherTEKRAR",cascade = CascadeType.PERSIST,orphanRemoval = true)
private AdvisorTeacherTEKRAR advisorTeacherTEKRAR;

@Column(name = "isAdvisorTEKRAR")
private boolean isAdvisorTEKRAR;

@Column(unique = true)
private String email;

@OneToMany(mappedBy = "teacherTEKRAR",cascade = CascadeType.REMOVE)
private List<StudentInfoTEKRAR>studentInfoTEKRARList;

@ManyToMany
@JoinTable(
        name = "teacherTEKRAR_lessonProgramTEKRAR",
        joinColumns = @JoinColumn(name = "teacherTEKRAR_id"),
        inverseJoinColumns = @JoinColumn(name = "lessonProgTEKRAR_id")
)
private Set<LessonProgramTEKRAR> lessonProgramTEKRARSet;




}
