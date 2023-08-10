package com.example.ApiRest.Service;

import com.example.ApiRest.Model.Teacher;
import com.example.ApiRest.Repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Anotación que marca la clase como un bean de servicio de Spring.
// Indica que esta clase contiene la lógica de negocio relacionada con la entidad 'Maestro'.
@Service
public class TeacherService {

    // @Autowired: Anotación que permite la inyección de dependencias automáticamente.
    // Inyecta el bean de repositorio 'MaestroRepositorio' en esta clase para que pueda acceder a sus métodos.
    @Autowired
    TeacherRepository teacherRepository;

    // Método para obtener todos los maestros.
    // Utiliza el método 'findAll()' proporcionado por 'MaestroRepositorio' para obtener una lista de todos los
    // maestros en la base de datos.
    public List<Teacher> findTeachers(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    // Método para obtener un maestro por su ID.
    // Utiliza el método 'findById()' proporcionado por 'MaestroRepositorio' para buscar un maestro específico por su ID.
    public Optional<Teacher> findTeacherById(Long id_teacher){
        return teacherRepository.findById(id_teacher);
    }

    // Método para registrar un nuevo maestro.
    // Utiliza el método 'save()' proporcionado por 'MaestroRepositorio' para guardar el maestro en la base de datos.
    public Teacher addTeacher(Teacher teacher){

        return teacherRepository.save(teacher);

    }

    // Método para actualizar los datos de un maestro existente.
    // Utiliza el método 'findById()' para obtener el maestro actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos del maestro.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void updateTeacher(Teacher teacher, Long id_teacher){
        teacherRepository.findById(id_teacher)
                .map(teacher1 -> {
                    teacher1.setNombre(teacher.getNombre());
                    teacher1.setEmail(teacher.getEmail());
                    teacher1.setLast_name(teacher.getLast_name());
                    teacher1.setAddress(teacher.getAddress());
                    teacher1.setPhone_number(teacher.getPhone_number());
                    return teacherRepository.save(teacher1);
                });
    }

    // Método para borrar un maestro por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'MaestroRepositorio' para eliminar el maestro de la base de datos.
    public void deleteTeacher(Long id_teacher){
        teacherRepository.deleteById(id_teacher);
    }

}