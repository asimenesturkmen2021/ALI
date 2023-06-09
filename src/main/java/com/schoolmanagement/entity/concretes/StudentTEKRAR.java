package com.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class StudentTEKRAR extends UserTEKRAR {
    private String motherName;
    private String fatherName;
    private int studentNumber;

    private boolean isActive;

    @Column(unique = true)
    private String email;

    //bircok ogrencinin bir rehber ogretmeni var.bir rehber ogretmenin bircok ogrencisi var
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private AdvisorTeacherTEKRAR advisorTeacherTEKRAR;

    @OneToMany(mappedBy = "studentTEKRAR")
    @JsonIgnore
    private List<StudentInfoTEKRAR> studentInfoTEKRARList;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "studentTEKRAR_lessonProgramTEKRAR",
            joinColumns = @JoinColumn(name = "studentTEKRAR_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_program_TEKRAR_id")
    )
    private Set<LessonProgramTEKRAR> lessonProgramTEKRARSet;


    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "meetTEKRAR_studentTEKRAR",
            joinColumns = @JoinColumn(name = "studentTEKRAR_id"),
            inverseJoinColumns = @JoinColumn(name = "meetTEKRAR_id")
    )
    private List<MeetTEKRAR>meetTEKRARList;

















}
