package fr.esgi.flutter_auth_api.rest.advice;

import fr.esgi.flutter_auth_api.exception.LoginErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AuthentificationRestControllerAdvice {
    @ExceptionHandler(LoginErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleExerciceNotFoundException(LoginErrorException e){
        return e.getMessage();
    }
}
