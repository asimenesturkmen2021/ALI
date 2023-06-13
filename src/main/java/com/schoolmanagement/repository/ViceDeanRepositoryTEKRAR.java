package com.schoolmanagement.repository;

public interface ViceDeanRepositoryTEKRAR {
    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);
}
