package com.example.ApiRest.Entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "materias")
public class Materia {

    // @Id: Indica que el atributo 'id' es la clave primaria de la entidad.
    // @GeneratedValue: Especifica que el valor del atributo 'id' se generará automáticamente mediante una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Se utiliza para mapear el atributo 'nombre' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'nombre' no puede ser nulo en la tabla.
    @Max(80)
    @NotBlank
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    // @Column: Se utiliza para mapear el atributo 'horario' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'horario' no puede ser nulo en la tabla.
    @Max(80)
    @NotBlank
    @Column(name = "horario", nullable = false, length = 80)
    private String horario;

    // @Column: Se utiliza para mapear el atributo 'salon' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'salon' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'salon' no puede ser nulo en la tabla.
    @Max(50)
    @NotBlank
    @Column(name = "salon", unique = true, nullable = false, length = 50)
    private String salon;

    // @ManyToOne: Indica que la relación entre Materia y Maestro es de muchos a uno (varias materias pueden tener el mismo maestro).
    // Esto se refleja en la base de datos mediante una clave foránea en la tabla de materias (atributo 'maestro_id').
    // El atributo 'maestro' en la clase Materia representa la entidad relacionada Maestro.
    // Si no se especifica @JoinColumn, JPA utilizará el nombre del atributo 'maestro' más "_id" como el nombre de la columna foránea.
    @ManyToOne
    @JoinColumn(name = "maestro_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Maestro maestro;

//    // @OneToMany: Indica que la relación entre Materia y Estudiante es de uno a muchos (una materia puede tener varios estudiantes).
//    // 'mappedBy' se utiliza para especificar el nombre del atributo en la clase Estudiante que mapea la relación inversa.
//    // En este caso, el atributo 'materia' en la clase Estudiante representa la entidad relacionada Materia.
//    // Esto implica que el mapeo de la relación se realiza a través del atributo 'materia' en la clase Estudiante.

    @ManyToMany(mappedBy = "materias")
    private List<Estudiante> estudiantes;


}