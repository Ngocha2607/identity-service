package com.ngocha.identity_service.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserUpdateRequest {
    @Size(min = 8, message = "PASSWORD_INVALID")
    String password;

    String firstName;
    String lastName;
    LocalDate dob;
}
