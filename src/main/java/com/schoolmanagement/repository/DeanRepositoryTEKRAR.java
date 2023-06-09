package com.schoolmanagement.repository;

public interface DeanRepositoryTEKRAR {
    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);
}
