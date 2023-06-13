package com.schoolmanagement.entity.abstracts;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.schoolmanagement.entity.concretes.UserRole;
import com.schoolmanagement.entity.concretes.UserRoleTEKRAR;
import com.schoolmanagement.entity.enums.GenderTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@MappedSuperclass//db de olusmasin
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder//alt klaslar builder i kullanabilsin

public abstract class UserTEKRAR implements Serializable {

    private GenderTEKRAR genderTEKRAR;

    private String username;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String ssn;

    private String name;
    private String surname;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate birthDay;

    private String birthPlace;

    @Column(unique = true)
    private String phoneNumber;

    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UserRoleTEKRAR userRoleTEKRAR;







}
