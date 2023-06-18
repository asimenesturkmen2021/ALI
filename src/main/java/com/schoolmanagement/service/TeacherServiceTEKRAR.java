package com.schoolmanagement.service;

import com.schoolmanagement.entity.concretes.LessonProgram;
import com.schoolmanagement.entity.concretes.LessonProgramTEKRAR;
import com.schoolmanagement.entity.concretes.TeacherTEKRAR;
import com.schoolmanagement.entity.enums.RoleType;
import com.schoolmanagement.exception.BadRequestException;
import com.schoolmanagement.payload.dto.TeacherRequestDto;
import com.schoolmanagement.payload.request.TeacherRequestTEKRAR;
import com.schoolmanagement.payload.response.ResponseMessageTEKRAR;
import com.schoolmanagement.payload.response.TeacherResponseTEKRAR;
import com.schoolmanagement.repository.TeacherRepositoryTEKRAR;
import com.schoolmanagement.utils.FieldControl;
import com.schoolmanagement.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeacherServiceTEKRAR {
    private final TeacherRepositoryTEKRAR teacherRepositoryTEKRAR;
    private final LessonProgramService lessonProgramServiceTEKRAR;
    private final FieldControl fieldControl;
    private final PasswordEncoder passwordEncoder;
    private final TeacherRequestDto teacherRequestDto;
    private final UserRoleService userRoleService;

    // Not: Save() **********************************************************

    public ResponseMessageTEKRAR<TeacherResponseTEKRAR> save(TeacherRequestTEKRAR teacherRequestTEKRAR) {
        Set<LessonProgram>lessonPrograms=lessonProgramServiceTEKRAR.getLessonProgramById(teacherRequestTEKRAR.getLessonIdlist());

        if (lessonPrograms.size()==0) {
            throw new BadRequestException(Messages.LESSON_PROGRAM_NOT_FOUND_MESSAGE);

        }   else {
            //dublicate kontrolu
            fieldControl.checkDuplicate(teacherRequestTEKRAR.getPhoneNumber(),
                    teacherRequestTEKRAR.getSsn(),
                    teacherRequestTEKRAR.getUserName(),
                    teacherRequestTEKRAR.getEmail());
            // !!! dto -> POJO donusumu
            TeacherTEKRAR teacherTEKRAR=teacherDtoToPojo(teacherRequestTEKRAR);
            //rol bilgisi veriliyor
//          //  teacherTEKRAR.setUserRoleTEKRAR(userRoleService.getUserRole(RoleType.TEACHER));
//
//        //ders programi ekleniyor
   //         teacherTEKRAR.setLessonProgramTEKRARSet(lessonPrograms);





        }



return null;

    }// !!! dto -> POJO donusumu metodu
    public TeacherTEKRAR teacherDtoToPojo(TeacherRequestTEKRAR teacherRequestTEKRAR){
        return TeacherTEKRAR.builder()
                .name(teacherRequestTEKRAR.getName())
                .ssn(teacherRequestTEKRAR.getSsn())
                .email(teacherRequestTEKRAR.getEmail())
                .birthDay(teacherRequestTEKRAR.getBirthDay())
                .birthPlace(teacherRequestTEKRAR.getBirthPlace())
                .isAdvisorTEKRAR(teacherRequestTEKRAR.isAdvisorTeacher())
                .genderTEKRAR(teacherRequestTEKRAR.getGenderTEKRAR())
                .password(teacherRequestTEKRAR.getPassword())
                .phoneNumber(teacherRequestTEKRAR.getPhoneNumber())
                .username(teacherRequestTEKRAR.getUserName())
                .surname(teacherRequestTEKRAR.getSurName())
                .build();
    }
}
