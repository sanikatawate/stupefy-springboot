package com.mysterious.stupefy.controller;

import com.mysterious.stupefy.model.AuthRequest;
import com.mysterious.stupefy.model.User;
import com.mysterious.stupefy.service.JwtService;
import com.mysterious.stupefy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    public UserInfoService userInfoService;
    @Autowired
    public JwtService jwtService;
    @Autowired
    public AuthenticationManager authenticationManager;
    @GetMapping("/not-secure")
    public String notSecure(){
        return "Not Secure Endpoint";
    }
    @PostMapping("/signup")
    public String addNewUser(@RequestBody User user){
        return userInfoService.addUser(user);
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('USER')")
    public String userProfile(){
        return "Welcome User";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile(){
        return "Welcome Admin";
    }

    public String authenticateGetToken(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getEmail());
        } else{
            throw new UsernameNotFoundException("Invalid User Request");
        }
    }
}
