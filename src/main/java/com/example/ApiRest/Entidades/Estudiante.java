package com.example.ApiRest.Entidades;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "estudiantes")
public class Estudiante {

    // @Id: Indica que el atributo 'id' es la clave primaria de la entidad.
    // @GeneratedValue: Especifica que el valor del atributo 'id' se generará automáticamente mediante una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Se utiliza para mapear el atributo 'nombre' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'nombre' no puede ser nulo en la tabla.
    @NotBlank
//    @Max(80)
    @Column(name = "nombre_alumno", nullable = false, length = 80)
    private String nombre_alumno;


    // @Column: Se utiliza para mapear el atributo 'apellido_paterno' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // Por defecto, el atributo 'apellido_paterno' permite valores nulos en la tabla.
    @NotBlank
//    @Max(80)
    @Column(name = "apellido_paterno", length = 80, nullable = false)
    private String apellido_paterno;

    @NotBlank
//    @Max(80)
    @Column(name = "apellido_materno", length = 80, nullable = false)
    private String apellido_materno;

    @NotBlank
//    @Max(9)
    @Column(name = "no_control", unique = true, nullable = false, length = 10)
    private String no_control;

    @NotBlank
//    @Max(60)
    @Column(name = "carrera", nullable = false, length = 60)
    private String carrera;

    // @Column: Se utiliza para mapear el atributo 'email' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'email' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'email' no puede ser nulo en la tabla.
    @Email
    @NotBlank
    @Column(name = "direccion_email", unique = true, nullable = false, length = 100)
    private String direccion_email;


//    @Max(13)
    @NotBlank
    @Column(name = "telefono", unique = true, nullable = false, length = 13)
    private String telefono;
//    @OneToMany(mappedBy = "estudiante")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<Materia> materias;

//    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "estudiante_materia",
            joinColumns = @JoinColumn(name = "estudiante_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<Materia> materias = new ArrayList<>();


}