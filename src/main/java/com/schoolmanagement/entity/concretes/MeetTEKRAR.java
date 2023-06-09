package com.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class MeetTEKRAR implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "HH:mm")
    private LocalTime startTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("teacherTEKRAR")
    private AdvisorTeacherTEKRAR advisorTeacherTEKRAR;

    @ManyToMany
    @JoinTable(name = "meetTEKRAR_studentTEKRAR",
            joinColumns = @JoinColumn(name = "studentTEKRAR_id"),
            inverseJoinColumns = @JoinColumn(name = "meetTEKRAR_id")
    )
    private List<StudentTEKRAR>studentTEKRARList;
















}
