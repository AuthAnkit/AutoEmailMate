package com.AutoEmailMate.eg.Exceptions;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists() {
        super("Email Already Exists . LogIn with username and password OR Register with another Account");
    }
}
