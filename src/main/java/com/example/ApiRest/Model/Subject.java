package com.example.ApiRest.Model;

import com.example.ApiRest.Model.Enum.SubjectState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "subjects")
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    // @Id: Indica que el atributo 'id' es la clave primaria de la entidad.
    // @GeneratedValue: Especifica que el valor del atributo 'id' se generará automáticamente mediante una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Se utiliza para mapear el atributo 'nombre' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'nombre' no puede ser nulo en la tabla.
//    @Max(80)
    @NotBlank
    @Column(name = "name", nullable = false, length = 80)
    private String name;

    // @Column: Se utiliza para mapear el atributo 'horario' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'horario' no puede ser nulo en la tabla.
//    @Max(80)
    @NotBlank
    @Column(name = "schedule", nullable = false, length = 80)
    private String schedule;

    // @Column: Se utiliza para mapear el atributo 'salon' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'salon' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'salon' no puede ser nulo en la tabla.
//    @Max(50)
    @NotBlank
    @Column(name = "classroom", unique = true, nullable = false, length = 50)
    private String classroom;

    // @ManyToOne: Indica que la relación entre Materia y Maestro es de muchos a uno (varias materias pueden tener el mismo maestro).
    // Esto se refleja en la base de datos mediante una clave foránea en la tabla de materias (atributo 'maestro_id').
    // El atributo 'maestro' en la clase Materia representa la entidad relacionada Maestro.
    // Si no se especifica @JoinColumn, JPA utilizará el nombre del atributo 'maestro' más "_id" como el nombre de la columna foránea.
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Teacher teacher;

//    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column(name = "subject_state")
    private SubjectState subject_state;

    //@JsonIgnore sirve para que no haya un error de recursividad en entre tabla materias y estudiantes cuando se consulte un
    // estudiante y se muestren las materias
//
    @JsonIgnore
    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;


}