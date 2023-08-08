package com.example.ApiRest.Repository;

import com.example.ApiRest.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository: Anotación que marca la interfaz como un bean de repositorio de Spring.
// Indica a Spring que esta interfaz debe ser escaneada en busca de componentes de repositorio.
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    // JpaRepository<Materia, Long>: Esta interfaz extiende JpaRepository de Spring Data JPA.
    // Se parametriza con la clase de entidad 'Materia' y el tipo de dato del atributo 'id', que es 'Long'.
    // Esto significa que esta interfaz manejará operaciones CRUD y otras consultas relacionadas con la entidad 'Materia'.

    // No se definen métodos aquí, ya que JpaRepository proporciona métodos predefinidos para realizar operaciones CRUD básicas
    // sobre la entidad 'Materia'. Estos métodos incluyen findById(), findAll(), save(), deleteById(), entre otros.

}
