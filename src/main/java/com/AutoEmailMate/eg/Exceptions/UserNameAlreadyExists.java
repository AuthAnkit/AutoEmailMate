package com.AutoEmailMate.eg.Exceptions;

public class UserNameAlreadyExists extends RuntimeException {
    public UserNameAlreadyExists() {
        super("UserName Already Exists , Choose Other UserName");
    }
}
