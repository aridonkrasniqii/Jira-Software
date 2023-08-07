package io.jira.domain.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class CreateUser  {

    @NotBlank(message = "First name must not be blank")
    @Size(max = 50, message = "First name must be at most 50 characters")
    String firstName;


    @NotBlank(message = "Last name must not be blank")
    @Size(max = 50, message = "Last name must be at most 50 characters")
    String lastName;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email must be at most 100 characters")
    String email;


    @NotBlank(message = "Password must not be blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    String password;

    @NotBlank(message = "Position must not be blank")
    @Size(max = 100, message = "Position must be at most 100 characters")
    String position;

    boolean isActive = false;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPosition() {
        return position;
    }

    public boolean isActive() {
        return isActive;
    }
}
