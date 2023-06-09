package com.schoolmanagement.entity.concretes;

import com.schoolmanagement.entity.enums.RoleTypeTEKRAR;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "userrolestekrar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UserRoleTEKRAR {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleTypeTEKRAR roleTypeTEKRAR;





}
