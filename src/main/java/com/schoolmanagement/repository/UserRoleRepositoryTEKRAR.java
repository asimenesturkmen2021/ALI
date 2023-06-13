package com.schoolmanagement.repository;

import com.schoolmanagement.entity.concretes.UserRoleTEKRAR;
import com.schoolmanagement.entity.enums.RoleTypeTEKRAR;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepositoryTEKRAR extends JpaRepository<UserRoleTEKRAR,Integer> {
    Optional<UserRoleTEKRAR> findByERoleEquals(RoleTypeTEKRAR roleTypeTEKRAR);

    Optional<UserRoleTEKRAR> findByERoleEqual(RoleTypeTEKRAR roleTypeTEKRAR);
}
