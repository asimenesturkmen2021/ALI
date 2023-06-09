package com.schoolmanagement.payload.response.abstracts;

import com.schoolmanagement.entity.enums.Gender;
import com.schoolmanagement.entity.enums.GenderTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class BaseUserResponseTEKRAR {
    private Long userId;
    private String username;
    private String name;
    private String surname;
    private LocalDate birthDay;
    private String ssn;
    private String birthPlace;
    private String phoneNumber;
    private GenderTEKRAR genderTEKRAR;
}
