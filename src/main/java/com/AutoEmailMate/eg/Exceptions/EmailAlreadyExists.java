package com.AutoEmailMate.eg.Exceptions;

import org.aspectj.bridge.IMessage;

public class EmailAlreadyExists extends RuntimeException {
    public EmailAlreadyExists(String message) {
        super(message);
    }
}
