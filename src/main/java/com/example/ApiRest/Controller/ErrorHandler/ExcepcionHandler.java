package com.example.ApiRest.Controller.ErrorHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExcepcionHandler {

    @ExceptionHandler(StudentNotFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String estudianteNoEncontradoManejador(StudentNotFound ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler(SubjectNotFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String materiaNoEncontradaManejador(SubjectNotFound ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler(TeacherNotFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String maestroNoEncontradoManejador(TeacherNotFound ex)
    {
        return ex.getMessage();
    }

}
