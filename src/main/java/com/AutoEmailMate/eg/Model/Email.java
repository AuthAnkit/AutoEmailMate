package com.AutoEmailMate.eg.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String to;
   private String message;
   private String subject;
}
