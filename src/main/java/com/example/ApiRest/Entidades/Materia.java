package com.example.ApiRest.Entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_materias")
public class Materia {

    // @Id: Indica que el atributo 'id' es la clave primaria de la entidad.
    // @GeneratedValue: Especifica que el valor del atributo 'id' se generará automáticamente mediante una estrategia de identidad.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column: Se utiliza para mapear el atributo 'nombre' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'nombre' no puede ser nulo en la tabla.
    @Column(name = "nombre", nullable = false)
    private String nombre;

    // @Column: Se utiliza para mapear el atributo 'horario' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'horario' no puede ser nulo en la tabla.
    @Column(name = "horario", nullable = false)
    private String horario;

    // @Column: Se utiliza para mapear el atributo 'salon' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'salon' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'salon' no puede ser nulo en la tabla.
    @Column(name = "salon", unique = true, nullable = false)
    private String salon;

    // @ManyToOne: Indica que la relación entre Materia y Maestro es de muchos a uno (varias materias pueden tener el mismo maestro).
    // Esto se refleja en la base de datos mediante una clave foránea en la tabla de materias (atributo 'maestro_id').
    // El atributo 'maestro' en la clase Materia representa la entidad relacionada Maestro.
    // Si no se especifica @JoinColumn, JPA utilizará el nombre del atributo 'maestro' más "_id" como el nombre de la columna foránea.
    @ManyToOne
    private Maestro maestro;

    // @OneToMany: Indica que la relación entre Materia y Estudiante es de uno a muchos (una materia puede tener varios estudiantes).
    // 'mappedBy' se utiliza para especificar el nombre del atributo en la clase Estudiante que mapea la relación inversa.
    // En este caso, el atributo 'materia' en la clase Estudiante representa la entidad relacionada Materia.
    // Esto implica que el mapeo de la relación se realiza a través del atributo 'materia' en la clase Estudiante.
    @OneToMany(mappedBy = "materia")
    private List<Estudiante> estudiante;
}