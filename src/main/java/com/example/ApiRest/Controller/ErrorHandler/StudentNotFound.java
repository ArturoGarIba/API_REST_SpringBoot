package com.example.ApiRest.Controller.ErrorHandler;

public class StudentNotFound extends RuntimeException {

    private Long id;

    public StudentNotFound(Long id_student){
        super("No se pudo encontrar el estudiante con el ID: " + id_student + " en los registros ");
    }


}
