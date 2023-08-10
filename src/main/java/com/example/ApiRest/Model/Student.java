package com.example.ApiRest.Model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import com.example.ApiRest.Model.Enum.StudentState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    // @Id: Indica que el atributo 'id' es la clave primaria de la entidad.
    // @GeneratedValue: Especifica que el valor del atributo 'id' se generará automáticamente mediante una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Se utiliza para mapear el atributo 'nombre' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'nombre' no puede ser nulo en la tabla.
//    @NotBlank
//    @Max(80)
    @Column(name = "name_student", nullable = false, length = 80)
    private String name_student;


    // @Column: Se utiliza para mapear el atributo 'apellido_paterno' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // Por defecto, el atributo 'apellido_paterno' permite valores nulos en la tabla.

    @Column(name = "last_name", length = 80, nullable = false)
    private String last_name;



    @Column(name = "no_control", unique = true, nullable = false, length = 10)
    private String no_control;


    @Column(name = "degree", nullable = false, length = 60)
    private String degree;

    // @Column: Se utiliza para mapear el atributo 'email' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'email' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'email' no puede ser nulo en la tabla.
    @Email
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;


//    @Max(13)
//    @NotBlank
    @Min(10)
    @Column(name = "phone_number", unique = true, nullable = false, length = 13)
    private String phone_number;

//    @NotBlank
    @Column(name = "student_state")
    @Enumerated(EnumType.STRING)
    private StudentState student_state;

//    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "student_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects = new ArrayList<>();


}