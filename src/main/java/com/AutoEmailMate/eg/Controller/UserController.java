package com.AutoEmailMate.eg.Controller;

import com.AutoEmailMate.eg.DTO.request.EmailRequest;
import com.AutoEmailMate.eg.DTO.request.UserLoginReq;
import com.AutoEmailMate.eg.DTO.request.UserRegisterReq;
import com.AutoEmailMate.eg.Model.Email;
import com.AutoEmailMate.eg.Service.EmailService;
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

    @GetMapping("/greet")
    public String greeting(){
        return "Hello World!";
    }
    @PostMapping("/register")
    public  ResponseEntity<String> register(@RequestBody UserRegisterReq userRegisterReq) {
       String registerMessage = userService.registerUser(userRegisterReq);
         return ResponseEntity.ok(registerMessage);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginReq userLoginReq) {
        String loginMessage = userService.login(userLoginReq);
        return ResponseEntity.ok(loginMessage);
    }

}
