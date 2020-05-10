package com.letchic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "not found element with such id")
public class NoFoundException extends Exception{
    String message;

    public NoFoundException() {
    }
    NoFoundException(String str) {
        message = str;
    }
    public String toString() {
        return ("Exception Occurred: " + message);
    }
}
