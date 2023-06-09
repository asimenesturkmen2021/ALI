package com.schoolmanagement.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestTEKRAR {

@NotNull(message = "username must not be empty")
private String username;

@NotNull(message = "password must not be empty")
private String password;








}
