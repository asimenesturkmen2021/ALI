package com.schoolmanagement.service;

import com.schoolmanagement.entity.concretes.UserRoleTEKRAR;
import com.schoolmanagement.entity.enums.RoleTypeTEKRAR;
import com.schoolmanagement.repository.UserRoleRepository;
import com.schoolmanagement.repository.UserRoleRepositoryTEKRAR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleServiceTEKRAR {

    private final UserRoleRepositoryTEKRAR userRoleRepositoryTEKRAR;
    public UserRoleTEKRAR getUserRole(RoleTypeTEKRAR roleTypeTEKRAR) {

        Optional<UserRoleTEKRAR>userRoleTEKRAR=userRoleRepositoryTEKRAR.findByERoleEquals(roleTypeTEKRAR);
        return userRoleTEKRAR.orElse(null);

    }

    public UserRoleTEKRAR getUserRoleTEKRAR(RoleTypeTEKRAR roleTypeTEKRAR) {
        Optional<UserRoleTEKRAR>userRoleTEKRAR=userRoleRepositoryTEKRAR.findByERoleEqual(roleTypeTEKRAR);
    return userRoleTEKRAR.orElse(null);
    }
}
