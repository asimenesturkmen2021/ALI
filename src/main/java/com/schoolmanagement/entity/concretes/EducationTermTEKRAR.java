package com.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolmanagement.entity.enums.TermTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class EducationTermTEKRAR implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private TermTEKRAR termTEKRAR;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate lastRegisrationDate;

    @OneToMany(mappedBy = "educationTermTEKRAR",cascade = CascadeType.ALL)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<LessonProgramTEKRAR>lessonProgramTEKRARList;



















}
