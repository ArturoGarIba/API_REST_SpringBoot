package com.example.ApiRest.Controladores.ManejoExcepciones;

public class EstudianteNoEncontrado extends RuntimeException {

    private Long id;

    public EstudianteNoEncontrado(Long id){
        super("No se pudo encontrar el estudiante en los registros " + id);
    }


}
