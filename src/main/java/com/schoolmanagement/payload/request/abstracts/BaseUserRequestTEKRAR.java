package com.schoolmanagement.payload.request.abstracts;

import com.schoolmanagement.entity.enums.GenderTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseUserRequestTEKRAR implements Serializable {

    private String userName;
    private String name;
    private String surName;
    private LocalDate birthDay;
    private String ssn;
    private String birthPlace;
    private String password;
    private String phoneNumber;
    private GenderTEKRAR genderTEKRAR;









}
