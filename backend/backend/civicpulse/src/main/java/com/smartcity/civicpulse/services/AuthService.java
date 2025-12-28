package com.smartcity.civicpulse.services;

import com.smartcity.civicpulse.dto.LoginRequest;
import com.smartcity.civicpulse.dto.LoginResponse;
import com.smartcity.civicpulse.dto.Registation;
import com.smartcity.civicpulse.entity.Citizen;
import com.smartcity.civicpulse.entity.User;
import com.smartcity.civicpulse.repository.CitizenRepository;
import com.smartcity.civicpulse.repository.UserRepository;
import com.smartcity.civicpulse.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AuthService {
    private final UserRepository userRepository;
    private final CitizenRepository citizenRepository;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,CitizenRepository citizenRepository, JwtService jwtService) {

        this.userRepository = userRepository;
        this.citizenRepository = citizenRepository;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request)
    {

        User user= userRepository.findByEmail(request.getEmail()).orElse(null);
        if(user==null)
        {

            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "User does not exist"
        );

        }
        if(!user.getPassword().equals(request.getPassword()))
        {
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED,
                "Incorrect password"

        );
        }

       String token= jwtService.generateToken(user.getEmail() ,user.getRole());

            return new LoginResponse(true,token);

    }
    public String register(Registation request)
    {
        Citizen citizen=new Citizen();
        citizen.setName(request.getName());
        citizen.setEmail(request.getEmail());
        citizen.setAddress(request.getAddress());
        citizen.setPhone(request.getMobile_number());

        citizenRepository.save(citizen);

        User user=new User();
        user.setRole(request.getRole());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());


        userRepository.save(user);
         return "Registation successful";

    }

}