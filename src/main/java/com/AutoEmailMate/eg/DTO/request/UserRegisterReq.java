package com.AutoEmailMate.eg.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterReq {
    private String name;
    private String username;
    private String password;
    private String email;
}

