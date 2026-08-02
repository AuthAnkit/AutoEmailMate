package com.AutoEmailMate.eg.Controller;

import com.AutoEmailMate.eg.DTO.request.UserRegisterReq;
import com.AutoEmailMate.eg.Service.ServiceImpl.UserServiceImpl;
import com.AutoEmailMate.eg.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")

public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public  ResponseEntity<String> register(@RequestBody UserRegisterReq userRegisterReq) {
       String registerMessage = userService.registerUser(userRegisterReq);
         return ResponseEntity.ok(registerMessage);
    }


}
