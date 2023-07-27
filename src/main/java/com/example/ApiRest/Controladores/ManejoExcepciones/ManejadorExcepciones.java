package com.example.ApiRest.Controladores.ManejoExcepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ManejadorExcepciones {

    @ExceptionHandler(EstudianteNoEncontrado.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String estudianteNoEncontradoManejador(EstudianteNoEncontrado ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler(MateriaNoEncontrada.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String materiaNoEncontradaManejador(MateriaNoEncontrada ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler(MaestroNoEncontrado.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String maestroNoEncontradoManejador(MaestroNoEncontrado ex)
    {
        return ex.getMessage();
    }

}
