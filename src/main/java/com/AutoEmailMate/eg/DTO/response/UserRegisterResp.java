package com.AutoEmailMate.eg.DTO.response;

import jakarta.persistence.GenerationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegisterResp {
    private String name;
    private String username;
}
