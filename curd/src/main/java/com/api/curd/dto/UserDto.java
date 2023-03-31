package com.api.curd.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(
        description = "This is User DTO class"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    //Will return Custom message
    @Schema(
            description = " First Name"
    )
    @NotEmpty(message = "Hay please put firstname")
    private String firstName;
    //Will return default message
    @Schema(
            description = "Last Name"
    )
    @NotEmpty
    private String lastName;
    @Schema(
            description = "Email"
    )
    @NotEmpty
    @Email
    private String email;

}
