package com.AutoEmailMate.eg.Service;

import com.AutoEmailMate.eg.DTO.request.UserLoginReq;
import com.AutoEmailMate.eg.DTO.request.UserRegisterReq;
import org.springframework.stereotype.Service;

public interface UserService {

     String registerUser(UserRegisterReq userRegisterReq);
     String login(UserLoginReq userLoginReq);


}
