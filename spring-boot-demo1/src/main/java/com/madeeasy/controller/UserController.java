package com.madeeasy.controller;

import com.madeeasy.dto.UserRequest;
import com.madeeasy.dto.UserResponse;
import com.madeeasy.feign.ApiCall;
import com.madeeasy.service.JwtUtils;
import com.madeeasy.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
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

    @Autowired
    private ApiCall apiCall;
    @GetMapping("/")
    public String welcome(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        String jwtToken = authorization.substring(7);
        String authorizationHeader = "Bearer "+jwtToken;
        String welcome = apiCall.welcome(authorizationHeader);
        System.out.println("This is from demo appliction = " + welcome);
        return "welcome to madeeasy.com";
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
