package com.schoolmanagement.repository;

public interface StudentRepositoryTEKRAR {
    boolean existByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);

    boolean existsByUsername(String username);
}
