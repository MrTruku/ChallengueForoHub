package com.challengue.foro_alura.Controllers;

import com.challengue.foro_alura.DtoGetData.user.DtoLoginDataUser;
import com.challengue.foro_alura.DtoResponses.user.DtoResponseTokenData;
import com.challengue.foro_alura.Services.ServiceUser;
import com.challengue.foro_alura.dbRepository.*;
import com.challengue.foro_alura.models.*;
import com.challengue.foro_alura.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController
{
    @Autowired
    ServiceUser serviceUser;

    @PostMapping
    @Operation(summary = "Receive the username and password and it returns a JWT with authentication data", tags = "Authentication")
    public ResponseEntity checkAuthentication(@RequestBody DtoLoginDataUser dtoLoginDataUser)
    {
        return ResponseEntity.ok(serviceUser.authenticateUser(dtoLoginDataUser));
    }
}
