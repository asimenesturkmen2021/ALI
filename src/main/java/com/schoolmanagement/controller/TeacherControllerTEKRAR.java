package com.schoolmanagement.controller;

import com.schoolmanagement.payload.request.TeacherRequest;
import com.schoolmanagement.payload.request.TeacherRequestTEKRAR;
import com.schoolmanagement.payload.response.ResponseMessageTEKRAR;
import com.schoolmanagement.payload.response.TeacherResponse;
import com.schoolmanagement.payload.response.TeacherResponseTEKRAR;
import com.schoolmanagement.service.TeacherServiceTEKRAR;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("teachers")
@RequiredArgsConstructor
public class TeacherControllerTEKRAR {
    private final TeacherServiceTEKRAR teacherServiceTEKRAR;

    // Not: Save() **********************************************************
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER','ASSISTANTMANAGER')")
    @PostMapping("/save")// http:/localhost:8080/teachers/save
    public ResponseMessageTEKRAR<TeacherResponseTEKRAR> save(@RequestBody @Valid TeacherRequestTEKRAR teacherRequestTEKRAR) {

        return teacherServiceTEKRAR.save(teacherRequestTEKRAR);
    }


}
