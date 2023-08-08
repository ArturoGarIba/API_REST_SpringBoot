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
    public List<Teacher> obtenerMaestros(){
        return (List<Teacher>) teacherRepository.findAll();
    }

    // Método para obtener un maestro por su ID.
    // Utiliza el método 'findById()' proporcionado por 'MaestroRepositorio' para buscar un maestro específico por su ID.
    public Optional<Teacher> obtenerMaestro(Long id){
        return teacherRepository.findById(id);
    }

    // Método para registrar un nuevo maestro.
    // Utiliza el método 'save()' proporcionado por 'MaestroRepositorio' para guardar el maestro en la base de datos.
    public Teacher registrarMaestro(Teacher teacher){

        return teacherRepository.save(teacher);

    }

    // Método para actualizar los datos de un maestro existente.
    // Utiliza el método 'findById()' para obtener el maestro actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos del maestro.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void actualizarMaestro(Teacher teacher, Long id){
        teacherRepository.findById(id)
                .map(teacher1 -> {
                    teacher1.setNombre(teacher.getNombre());
                    teacher1.setEmail(teacher.getEmail());
                    teacher1.setApellido_paterno(teacher.getApellido_paterno());
                    teacher1.setDireccion(teacher.getDireccion());
                    teacher1.setTelefono(teacher.getTelefono());
                    return teacherRepository.save(teacher1);
                });
    }

    // Método para borrar un maestro por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'MaestroRepositorio' para eliminar el maestro de la base de datos.
    public void borrarMaestro(Long id){
        teacherRepository.deleteById(id);
    }

}