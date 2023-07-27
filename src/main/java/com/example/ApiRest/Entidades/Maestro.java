package com.example.ApiRest.Entidades;

import com.fasterxml.jackson.annotation.JsonProperty;
//import jakarta.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "maestros")
public class Maestro {

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

    // @Column: Se utiliza para mapear el atributo 'apellido_paterno' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'apellido_paterno' no puede ser nulo en la tabla.
    @Max(80)
    @NotBlank
    @Column(name = "apellido_paterno", nullable = false, length = 80)
    private String apellido_paterno;

    // @Column: Se utiliza para mapear el atributo 'email' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'email' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'email' no puede ser nulo en la tabla.
    @Max(100)
    @NotBlank
    @Email
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    // @Column: Se utiliza para mapear el atributo 'direccion' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'direccion' no puede ser nulo en la tabla.

    @Max(120)
    @NotBlank
    @Column(name = "direccion", nullable = false, length = 120)
    private String direccion;

    // @Column: Se utiliza para mapear el atributo 'telefono' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'telefono' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'telefono' no puede ser nulo en la tabla.
    @Min(10)
    @Max(13)
    @NotBlank
    @Column(name = "telefono", unique = true, nullable = false, length = 15)
    private String telefono;

//    // @OneToMany: Indica que la relación entre Maestro y Materia es de uno a muchos (un maestro puede tener varias materias).
//    // 'mappedBy' se utiliza para especificar el nombre del atributo en la clase Materia que mapea la relación inversa.
//    // En este caso, el atributo 'maestro' en la clase Materia representa la entidad relacionada Maestro.
//    // Esto implica que el mapeo de la relación se realiza a través del atributo 'maestro' en la clase Materia.

//    @OneToMany(mappedBy = "maestro")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private List<Materia> materias;

}