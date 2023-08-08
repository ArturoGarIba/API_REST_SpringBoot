package com.example.ApiRest.Model;

//import jakarta.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
import com.example.ApiRest.Model.Enum.TeacherState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "maestros")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

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
    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    // @Column: Se utiliza para mapear el atributo 'apellido_paterno' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'apellido_paterno' no puede ser nulo en la tabla.
//    @Max(80)
    @NotBlank
    @Column(name = "apellido_paterno", nullable = false, length = 80)
    private String apellido_paterno;

    // @Column: Se utiliza para mapear el atributo 'email' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'email' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'email' no puede ser nulo en la tabla.
//    @Max(100)
    @NotBlank
    @Email
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    // @Column: Se utiliza para mapear el atributo 'direccion' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'nullable = false' indica que el valor del atributo 'direccion' no puede ser nulo en la tabla.

//    @Max(120)
    @NotBlank
    @Column(name = "direccion", nullable = false, length = 120)
    private String direccion;

    // @Column: Se utiliza para mapear el atributo 'telefono' a una columna de la tabla.
    // 'name' especifica el nombre de la columna en la tabla.
    // 'unique = true' indica que el valor del atributo 'telefono' debe ser único en la tabla.
    // 'nullable = false' indica que el valor del atributo 'telefono' no puede ser nulo en la tabla.

//    @Max(13)
    @Min(10)
    @NotBlank
    @Column(name = "telefono", unique = true, nullable = false, length = 15)
    private String telefono;

//    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "teacher_state")
    private TeacherState teacher_state;

}