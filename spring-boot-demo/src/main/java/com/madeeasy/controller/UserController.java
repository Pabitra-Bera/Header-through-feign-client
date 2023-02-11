package com.madeeasy.controller;

import com.madeeasy.dto.UserRequest;
import com.madeeasy.dto.UserResponse;
import com.madeeasy.service.JwtUtils;
import com.madeeasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to madeeasy.com from demo project";
    }
    @PostMapping("/api/authentication")
    public ResponseEntity<?> getAuthenticated(@RequestBody UserRequest userRequest){
        String token = null;
        boolean flag = userService.validateUserName(userRequest.getName());
        if (flag){
            System.out.println(flag);
            token = jwtUtils.generateToken(userRequest.getName());
            System.out.println(token);
        }
        return ResponseEntity.ok(new UserResponse(token));
    }
}
