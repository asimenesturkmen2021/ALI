package com.schoolmanagement.repository;

public interface TeacherRepositoryTEKRAR {
    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);
}
