package com.example.ApiRest.Controller.ErrorHandler;

public class TeacherNotFound extends RuntimeException{

    private Long id;

    public TeacherNotFound(Long id_teacher){

        super("No se pudo encontrar el maestro con el ID: " + id_teacher + " en los registros ");

    }

}
