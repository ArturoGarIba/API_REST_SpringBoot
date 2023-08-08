package com.example.ApiRest.Controller.ErrorHandler;

public class SubjectNotFound extends RuntimeException{

    private Long id;

    public SubjectNotFound(Long id_materia){

        super("No se pudo encontrar la materia con el ID: " + id_materia + " en los registros ");

    }


}
