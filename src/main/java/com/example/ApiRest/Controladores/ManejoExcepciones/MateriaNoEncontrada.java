package com.example.ApiRest.Controladores.ManejoExcepciones;

public class MateriaNoEncontrada extends RuntimeException{

    private Long id;

    public MateriaNoEncontrada(Long id){
        super("No se pudo encontrar la materia en los registros " + id);
    }


}
