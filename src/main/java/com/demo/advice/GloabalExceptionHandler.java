package com.demo.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.exceptions.MovieException;

class ErrorMessage{
    private String type;
    private LocalDateTime time;
    private String message;

    public ErrorMessage(String type, String message) {
        this.type = type;
        this.message = message;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ErrorMessage [type=" + type + ", time=" + time + ", message=" + message + "]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    

}

@ControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler(MovieException.class)
    public ResponseEntity<ErrorMessage> handleMovieException(MovieException me){
        return new ResponseEntity<ErrorMessage>(
            new ErrorMessage(me.getClass().toString(), me.getMessage()), 
            HttpStatus.OK);
    }
    
}
