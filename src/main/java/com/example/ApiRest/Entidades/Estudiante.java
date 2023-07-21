package com.example.ApiRest.Entidades;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_estudiantes")
public class Estudiante {

    // @Id: Indica que el atributo 'id' es la clave primaria de la entidad.
    // @GeneratedValue: Especifica que el valor del atributo 'id' se generará automáticamente mediante una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Se utiliza para mapear el atributo 'nombre' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'nombre' no puede ser nulo en la tabla.
    @Column(name = "nombre_alumno", nullable = false)
    private String nombre;

    // @Column: Se utiliza para mapear el atributo 'apellido_paterno' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // Por defecto, el atributo 'apellido_paterno' permite valores nulos en la tabla.
    @Column(name = "apellido_paterno")
    private String apellido_paterno;

    // @Column: Se utiliza para mapear el atributo 'email' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'email' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'email' no puede ser nulo en la tabla.
    @Column(name = "direccion_email", unique = true, nullable = false)
    private String email;

    // @ManyToOne: Indica que la relación entre Estudiante y Materia es de muchos a uno (varios estudiantes pueden tener
    // la misma materia).
    // Esto se refleja en la base de datos mediante una clave foránea en la tabla de estudiantes (atributo 'materia_id').
    // El atributo 'materia' en la clase Estudiante representa la entidad relacionada Materia.
    // Si no se especifica @JoinColumn, JPA utilizará el nombre del atributo 'materia' más "_id" como el nombre de la columna foránea.
    @ManyToOne
    private Materia materia;
}