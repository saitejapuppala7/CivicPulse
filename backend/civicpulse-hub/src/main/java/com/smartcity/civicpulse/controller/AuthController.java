package com.smartcity.civicpulse.controller;

import com.smartcity.civicpulse.dto.LoginRequest;
import com.smartcity.civicpulse.dto.LoginResponse;
import com.smartcity.civicpulse.dto.Registation;
import com.smartcity.civicpulse.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;




@RestController

 @RequestMapping("/api")

public class AuthController {

    public AuthService authService;

    public AuthController(AuthService authService)
   {
       this.authService=authService;
    }
    @PostMapping("/login")
     public  LoginResponse login(@RequestBody LoginRequest request)
     {
         return authService.login(request);
     }
     @PostMapping("/register")
     public String register (@RequestBody Registation request)
     {
         return authService.register(request);
     }

}