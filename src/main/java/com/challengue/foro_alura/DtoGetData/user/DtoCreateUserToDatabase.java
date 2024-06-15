package com.challengue.foro_alura.DtoGetData.user;

import com.challengue.foro_alura.models.Profile;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DtoCreateUserToDatabase (String username,
                                       String email,
                                       String passwordEncrypted,
                                       Profile typeOfProfile){
}
