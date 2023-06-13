package com.schoolmanagement.repository;

import com.schoolmanagement.entity.concretes.AdminTEKRAR;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositoryTEKRAR extends JpaRepository<AdminTEKRAR,Long> {
    boolean existsByUsername(String username);

    boolean existsBySsn(String ssn);

    boolean existsByPhoneNumber(String phone);



}
