package com.schoolmanagement.entity.concretes;

import com.schoolmanagement.entity.abstracts.UserTEKRAR;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class DeanTEKRAR extends UserTEKRAR {
}
