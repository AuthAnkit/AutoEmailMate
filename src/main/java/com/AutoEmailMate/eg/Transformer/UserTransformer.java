package com.AutoEmailMate.eg.Transformer;

import com.AutoEmailMate.eg.DTO.request.UserLoginReq;
import com.AutoEmailMate.eg.DTO.request.UserRegisterReq;
import com.AutoEmailMate.eg.DTO.response.UserRegisterResp;
import com.AutoEmailMate.eg.Model.User;

public class UserTransformer {
        public static User toEntity(UserRegisterReq UserRegisterReq) {
            return User.builder()
                    .name(UserRegisterReq.getName())
                    .username(UserRegisterReq.getUsername())
                    .password(UserRegisterReq.getPassword())
                    .email(UserRegisterReq.getEmail())
                    .build();
        }

        public static String toMessage(UserRegisterResp userRegisterResp) {
            return "User registered successfully with username: " + userRegisterResp.getUsername();
        }

}
