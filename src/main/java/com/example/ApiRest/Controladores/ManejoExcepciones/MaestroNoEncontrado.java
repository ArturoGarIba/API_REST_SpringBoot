package com.example.ApiRest.Controladores.ManejoExcepciones;

public class MaestroNoEncontrado extends RuntimeException{

    private Long id;

    public MaestroNoEncontrado(Long id){
        super("No se pudo encontrar el maestro en los registros " + id);
    }

}
