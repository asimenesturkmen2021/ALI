package com.schoolmanagement.payload.response;

import com.schoolmanagement.entity.concretes.Admin;
import com.schoolmanagement.entity.concretes.AdminTEKRAR;
import com.schoolmanagement.entity.enums.RoleTypeTEKRAR;
import com.schoolmanagement.exception.ConflictException;
import com.schoolmanagement.payload.request.AdminRequestTEKRAR;
import com.schoolmanagement.repository.*;
import com.schoolmanagement.service.UserRoleService;
import com.schoolmanagement.service.UserRoleServiceTEKRAR;
import com.schoolmanagement.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AdminServiceTEKRAR {

    private AdminRepositoryTEKRAR adminRepositoryTEKRAR;
    private final StudentRepositoryTEKRAR studentRepositoryTEKRAR;
    private final ViceDeanRepositoryTEKRAR viceDeanRepositoryTEKRAR;
    private final DeanRepositoryTEKRAR deanRepositoryTEKRAR;
    private final TeacherRepositoryTEKRAR teacherRepositoryTEKRAR;
    private final GuestUserRepositoryTEKRAR guestUserRepositoryTEKRAR;

    private final UserRoleServiceTEKRAR userRoleServiceTEKRAR;

    // private final PasswordEncoderTEKRAR passwordEncoderTEKRAR;

    // Not: save()  *******************************************************
//    public ResponseMessageTEKRAR save(AdminRequestTEKRAR adminRequestTEKRAR) {
//        // !!! Girilen username - ssn- phoneNumber unique mi kontrolu
//        checkDuplicate(adminRequestTEKRAR.getUserName(), adminRequestTEKRAR.getSsn(), adminRequestTEKRAR.getPhoneNumber());
//        // !!! Admin nesnesi(pojo) builder ile olusturalim
//        AdminTEKRAR adminTEKRAR = createAdminTEKRARForSave(adminRequestTEKRAR);
//        adminTEKRAR.setBuilt_in(false);
//
//        if (Objects.equals(adminRequestTEKRAR.getUserName(), "Admin")) adminTEKRAR.setBuilt_in(true);
//        // !!! admin rolu veriliyor
//        adminTEKRAR.setUserRoleTEKRAR(userRoleServiceTEKRAR.getUserRoleTEKRAR(RoleTypeTEKRAR.ADMIN));
//        //!!! password encode ediliyor
////adminTEKRAR.setPassword(passwordEncoder.encode(adminTEKRAR.getPassword()));
//
//       // AdminTEKRAR savedDate=adminRepositoryTEKRAR.save(adminTEKRAR);
//return ResponseMessageTEKRAR.<AdminResponseTEKRAR>builder()
//        .message("admin saved")
//        .httpStatus(HttpStatus.CREATED);
        //.object(createResponse(saveDate));


    private AdminResponseTEKRAR createResponse(AdminTEKRAR adminTEKRAR){

        return AdminResponseTEKRAR.builder()
                .userId(adminTEKRAR.getId())
                .username(adminTEKRAR.getUsername())
                .name(adminTEKRAR.getName())
                .surname(adminTEKRAR.getSurname())
                .phoneNumber(adminTEKRAR.getPhoneNumber())
                .genderTEKRAR(adminTEKRAR.getGenderTEKRAR())
                .ssn(adminTEKRAR.getSsn())
                .build();
    }


    public void checkDuplicate(String username, String ssn, String phone) {
        if (adminRepositoryTEKRAR.existsByUsername(username) ||
                deanRepositoryTEKRAR.existsByUsername(username) ||
                studentRepositoryTEKRAR.existsByUsername(username) ||
                teacherRepositoryTEKRAR.existsByUsername(username) ||
                viceDeanRepositoryTEKRAR.existsByUsername(username) ||
                guestUserRepositoryTEKRAR.existsByUsername(username)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_USERNAME, username));
        } else if (adminRepositoryTEKRAR.existsBySsn(ssn) ||
                deanRepositoryTEKRAR.existsBySsn(ssn) ||
                studentRepositoryTEKRAR.existsBySsn(ssn) ||
                teacherRepositoryTEKRAR.existsBySsn(ssn) ||
                viceDeanRepositoryTEKRAR.existsBySsn(ssn) ||
                guestUserRepositoryTEKRAR.existsBySsn(ssn)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_SSN, ssn));
        } else if (adminRepositoryTEKRAR.existsByPhoneNumber(phone) ||
                deanRepositoryTEKRAR.existsByPhoneNumber(phone) ||
                studentRepositoryTEKRAR.existsByPhoneNumber(phone) ||
                teacherRepositoryTEKRAR.existsByPhoneNumber(phone) ||
                viceDeanRepositoryTEKRAR.existsByPhoneNumber(phone) ||
                guestUserRepositoryTEKRAR.existsByPhoneNumber(phone)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_PHONE_NUMBER, phone));
        }
    }

    //dto ==>pojo donusumu
    protected AdminTEKRAR createAdminTEKRARForSave(AdminRequestTEKRAR adminRequestTEKRAR) {

        return AdminTEKRAR.builder()
                .username(adminRequestTEKRAR.getUserName())
                .name(adminRequestTEKRAR.getName())
                .surname(adminRequestTEKRAR.getSurName())
                .password(adminRequestTEKRAR.getPassword())
                .ssn(adminRequestTEKRAR.getSsn())
                .birthDay(adminRequestTEKRAR.getBirthDay())
                .birthPlace(adminRequestTEKRAR.getBirthPlace())
                .phoneNumber(adminRequestTEKRAR.getPhoneNumber())
                .genderTEKRAR(adminRequestTEKRAR.getGenderTEKRAR())
                .build();
    }


}



    /*
     ODEV -- yukardaki duplicate methodunu 4 parametreli hale getirmek istersem ???
     /*    public void checkDuplicate2(String... values) {
        String username = values[0];
        String ssn = values[1];
        String phone = values[2];
        String email = values[3];

        if (adminRepository.existsByUsername(username) || deanRepository.existsByUsername(username) ||
                studentRepository.existsByUsername(username) || teacherRepository.existsByUsername(username) ||
                viceDeanRepository.existsByUsername(username) || guestUserRepository.existsByUsername(username)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_USERNAME, username));
        } else if (adminRepository.existsBySsn(ssn) || deanRepository.existsBySsn(ssn) ||
                studentRepository.existsBySsn(ssn) || teacherRepository.existsBySsn(ssn) ||
                viceDeanRepository.existsBySsn(ssn) || guestUserRepository.existsBySsn(ssn)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_SSN, ssn));
        } else if (adminRepository.existsByPhoneNumber(phone) || deanRepository.existsByPhoneNumber(phone) ||
                studentRepository.existsByPhoneNumber(phone) || teacherRepository.existsByPhoneNumber(phone) ||
                viceDeanRepository.existsByPhoneNumber(phone) || guestUserRepository.existsByPhoneNumber(phone)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_PHONE_NUMBER, phone));
        } else if (studentRepository.existsByEmail(email) || teacherRepository.existsByEmail(email)) {
            throw new ConflictException(String.format(Messages.ALREADY_REGISTER_MESSAGE_EMAIL, email));
        }// checkDuplicate VarArgs cozumu ( Odev olarak Ver )
    */


