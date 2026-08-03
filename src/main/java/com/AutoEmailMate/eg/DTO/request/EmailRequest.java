package com.AutoEmailMate.eg.DTO.request;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailRequest {
    private String to;
    private String message;
    private String subject;
}
