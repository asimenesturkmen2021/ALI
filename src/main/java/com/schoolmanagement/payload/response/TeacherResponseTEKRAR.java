package com.schoolmanagement.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.schoolmanagement.entity.concretes.LessonProgram;
import com.schoolmanagement.entity.concretes.LessonProgramTEKRAR;
import com.schoolmanagement.payload.response.abstracts.BaseUserResponseTEKRAR;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherResponseTEKRAR extends BaseUserResponseTEKRAR {

    private Set<LessonProgramTEKRAR> lessonProgramTEKRARset;
    private String email;

}
