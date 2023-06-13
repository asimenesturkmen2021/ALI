package com.schoolmanagement.service;

import com.schoolmanagement.entity.concretes.Admin;
import com.schoolmanagement.entity.concretes.AdminTEKRAR;
import com.schoolmanagement.entity.enums.RoleTypeTEKRAR;
import com.schoolmanagement.exception.ConflictException;
import com.schoolmanagement.payload.request.AdminRequestTEKRAR;
import com.schoolmanagement.payload.response.AdminResponse;
import com.schoolmanagement.payload.response.AdminResponseTEKRAR;
import com.schoolmanagement.payload.response.ResponseMessage;
import com.schoolmanagement.payload.response.ResponseMessageTEKRAR;
import com.schoolmanagement.repository.*;
import com.schoolmanagement.utils.Messages;
import com.schoolmanagement.utils.MessagesTEKRAR;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service//servis klasi
@RequiredArgsConstructor//final fieldlardan constr. depend. injection yapar.
public class AdminServiceTEKRAR {
    private final AdminRepositoryTEKRAR adminRepositoryTEKRAR;

    private final StudentRepositoryTEKRAR studentRepositoryTEKRAR;
    private final ViceDeanRepositoryTEKRAR viceDeanRepositoryTEKRAR;
    private final TeacherRepositoryTEKRAR teacherRepositoryTEKRAR;
    private final GuestUserRepositoryTEKRAR guestUserRepositoryTEKRAR;
    private final DeanRepositoryTEKRAR deanRepositoryTEKRAR;

    private final UserRoleServiceTEKRAR userRoleServiceTEKRAR;

    //private final PasswordEncoderTEKRAR passwordEncoderTEKRAR;


    // Not: save()  ADMIN I KAYDEDIYORUZ****************************
    public ResponseMessageTEKRAR save(AdminRequestTEKRAR adminRequestTEKRAR) {

        // !!! Girilen username - ssn- phoneNumber unique mi kontrolu
        checkDuplicate(adminRequestTEKRAR.getUserName(), adminRequestTEKRAR.getSsn(), adminRequestTEKRAR.getPhoneNumber());

        // !!! Admin nesnesi builder ile olusturalim
        AdminTEKRAR adminTEKRAR = createAdminForSave(adminRequestTEKRAR);
        adminTEKRAR.setBuilt_in(false);

        if (Objects.equals(adminRequestTEKRAR.getUserName(), "Admin")) adminTEKRAR.setBuilt_in(true);

        //ADMIN ROLU VERILIYOR
        adminTEKRAR.setUserRoleTEKRAR(userRoleServiceTEKRAR.getUserRole(RoleTypeTEKRAR.ADMIN));

        //!!! password encode ediliyor
        //adminTEKRAR.setPassword(passwordEncoder.encode);

        AdminTEKRAR savedDate = adminRepositoryTEKRAR.save(adminTEKRAR);

        return ResponseMessageTEKRAR.<AdminResponseTEKRAR>builder()
                .message("Admin saved")
                .httpStatus(HttpStatus.CREATED)
                .object(createResponse(savedDate)) // pojo- dto
                .build();


    }

    private AdminResponseTEKRAR createResponse(AdminTEKRAR admin) {

        return AdminResponseTEKRAR.builder()
                .userId(admin.getId())
                .username(admin.getUsername())
                .name(admin.getName())
                .surname(admin.getSurname())
                .phoneNumber(admin.getPhoneNumber())
                .genderTEKRAR(admin.getGenderTEKRAR())
                .ssn(admin.getSsn())
                .build();
    }
    //DTO YU POJO YA CEVIRIYORUZ


    protected AdminTEKRAR createAdminForSave(AdminRequestTEKRAR adminRequestTEKRAR) {
        return AdminTEKRAR.builder().
                username(adminRequestTEKRAR.getUserName()).
                name(adminRequestTEKRAR.getName()).
                surname(adminRequestTEKRAR.getSurName()).
                password(adminRequestTEKRAR.getPassword())
                .ssn(adminRequestTEKRAR.getSsn())
                .birthDay(adminRequestTEKRAR.getBirthDay())
                .birthPlace(adminRequestTEKRAR.getBirthPlace())
                .phoneNumber(adminRequestTEKRAR.getPhoneNumber())
                .genderTEKRAR(adminRequestTEKRAR.getGenderTEKRAR())
                .build();
    }

    public void checkDuplicate(String username, String ssn, String phone) {
        if (adminRepositoryTEKRAR.existsByUsername(username) ||
                deanRepositoryTEKRAR.existsByUsername(username) ||
                studentRepositoryTEKRAR.existByUsername(username) ||
                teacherRepositoryTEKRAR.existsByUsername(username) ||
                viceDeanRepositoryTEKRAR.existsByUsername(username) ||
                guestUserRepositoryTEKRAR.existsByUsername(username)
        ) {
            throw new ConflictException(String.format(MessagesTEKRAR.ALREADY_REGISTER_MESSAGE_USERNAME, username));
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

    // Not: getALL()********************************************************
    public Page<AdminTEKRAR> getAllAdminTEKRAR(Pageable pageable) {
        return adminRepositoryTEKRAR.findAll(pageable);
    }

    public String deleteAdmin(Long id) {

        Optional<AdminTEKRAR> adminTEKRAR = adminRepositoryTEKRAR.findById(id);
        if (adminTEKRAR.isPresent() && adminTEKRAR.get().isBuilt_in()) {
            throw new ConflictException(MessagesTEKRAR.NOT_PERMITTED_METHOD_MESSAGE);
        }
        if (adminTEKRAR.isPresent()) {
            adminRepositoryTEKRAR.deleteById(id);
            return "admin is deleted Successfully";
        }
        return MessagesTEKRAR.NOT_FOUND_USER_MESSAGE;
    }

    // !!! Runner tarafi icin yazildi
    public long countAllAdmin() {
        return adminRepositoryTEKRAR.count();
    }
}
