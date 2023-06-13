package com.schoolmanagement.repository;

public interface GuestUserRepositoryTEKRAR {
    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);
}
