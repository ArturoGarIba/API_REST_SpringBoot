package com.example.ApiRest.Repositorios;

import com.example.ApiRest.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// @Repository: Anotación que marca la interfaz como un bean de repositorio de Spring.
// Indica a Spring que esta interfaz debe ser escaneada en busca de componentes de repositorio.
@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long> {

    // JpaRepository<Estudiante, Long>: Esta interfaz extiende JpaRepository de Spring Data JPA.
    // Se parametriza con la clase de entidad 'Estudiante' y el tipo de dato del atributo 'id', que es 'Long'.
    // Esto significa que esta interfaz manejará operaciones CRUD y otras consultas relacionadas con la entidad 'Estudiante'.

    // No se definen métodos aquí, ya que JpaRepository proporciona métodos predefinidos para realizar operaciones CRUD básicas
    // sobre la entidad 'Estudiante'. Estos métodos incluyen findById(), findAll(), save(), deleteById(), entre otros.


}