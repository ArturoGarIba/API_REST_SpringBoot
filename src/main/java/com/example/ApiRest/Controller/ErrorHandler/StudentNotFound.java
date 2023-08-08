package com.example.ApiRest.Controller.ErrorHandler;

public class StudentNotFound extends RuntimeException {

    private Long id;

    public StudentNotFound(Long id_estudiante){
        super("No se pudo encontrar el estudiante con el ID: " + id_estudiante + " en los registros ");
    }


}
