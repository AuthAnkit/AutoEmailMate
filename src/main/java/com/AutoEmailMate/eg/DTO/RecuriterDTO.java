package com.AutoEmailMate.eg.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecuriterDTO {
    private String company;
    private String name;
    private String designation;
    private String email;

}
