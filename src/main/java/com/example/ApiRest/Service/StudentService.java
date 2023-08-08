package com.example.ApiRest.Service;

import com.example.ApiRest.Model.Student;
import com.example.ApiRest.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Anotación que marca la clase como un bean de servicio de Spring.
// Indica que esta clase contiene la lógica de negocio relacionada con la entidad 'Estudiante'.
@Service
public class StudentService {

    // @Autowired: Anotación que permite la inyección de dependencias automáticamente.
    // Inyecta el bean de repositorio 'EstudianteRepositorio' en esta clase para que pueda acceder a sus métodos.
    @Autowired
    StudentRepository studentRepository;

    // Método para obtener todos los estudiantes.
    // Utiliza el método 'findAll()' proporcionado por 'EstudianteRepositorio' para obtener una lista de todos los
    // estudiantes en la base de datos.
    public List<Student> obtenerEstudiantes(){
        return (List<Student>) studentRepository.findAll();
    }

    // Método para obtener un estudiante por su ID.
    // Utiliza el método 'findById()' proporcionado por 'EstudianteRepositorio' para buscar un estudiante específico por su ID.
    public Optional<Student> obtenerEstudiante(Long id){
        return studentRepository.findById(id);
    }

    // Método para registrar un nuevo estudiante.
    // Utiliza el método 'save()' proporcionado por 'EstudianteRepositorio' para guardar el estudiante en la base de datos.
    public Student registrarEstudiante(Student student){
        return studentRepository.save(student);
    }

    // Método para actualizar los datos de un estudiante existente.
    // Utiliza el método 'findById()' para obtener el estudiante actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos del estudiante.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void actualizarEstudiante(Student student, Long id){
        studentRepository.findById(id)
                .map(student1 -> {
                    student1.setNombre_alumno(student.getNombre_alumno());
                    student1.setApellido_paterno(student.getApellido_paterno());
                    student1.setApellido_materno(student.getApellido_materno());
                    student1.setCarrera(student.getCarrera());
                    student1.setDireccion_email(student.getDireccion_email());
                    student1.setNo_control(student.getNo_control());
                    student1.setStudent_state(student.getStudent_state());
                    student1.setTelefono(student.getTelefono());

                    return studentRepository.save(student1);
                });
    }

    // Método para borrar un estudiante por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'EstudianteRepositorio' para eliminar el estudiante de la base de datos.
    public void borrarEstudiante(Long id){
        studentRepository.deleteById(id);
    }

}