package com.example.ApiRest.Controller.ErrorHandler;

public class SubjectNotFound extends RuntimeException{

    private Long id;

    public SubjectNotFound(Long id_subject){

        super("No se pudo encontrar la materia con el ID: " + id_subject + " en los registros ");

    }


}
