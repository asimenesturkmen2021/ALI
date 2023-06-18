package com.schoolmanagement.payload.request;

import com.schoolmanagement.payload.request.abstracts.BaseUserRequestTEKRAR;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class TeacherRequestTEKRAR extends BaseUserRequestTEKRAR {

    @NotNull(message = "Please select lesson")
    private Set<Long> lessonIdlist;

    @NotNull(message = "Please select isAdvisor Teacher")
    private boolean isAdvisorTeacher;

    @NotNull(message = "Please select your email")
    @Email(message = "Please enter valid email")
    @Size(min = 5,max = 50,message = "Your email should be between 5 and 50 chars")
    private  String email;


}
