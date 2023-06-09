package com.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdvisorTeacherTEKRAR implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRoleTEKRAR userRoleTEKRAR;

    @OneToOne
    private TeacherTEKRAR teacherTEKRAR;

    @OneToMany(mappedBy = "advisorTeacherTEKRAR",orphanRemoval = true,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<StudentTEKRAR>studentTEKRARList;

    @OneToMany(mappedBy = "advisorTeacherTEKRAR",cascade = CascadeType.ALL)
    private List<MeetTEKRAR>meetTEKRARList;


}
