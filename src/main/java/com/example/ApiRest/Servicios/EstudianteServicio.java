package com.example.ApiRest.Servicios;

import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Repositorios.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Anotación que marca la clase como un bean de servicio de Spring.
// Indica que esta clase contiene la lógica de negocio relacionada con la entidad 'Estudiante'.
@Service
public class EstudianteServicio {

    // @Autowired: Anotación que permite la inyección de dependencias automáticamente.
    // Inyecta el bean de repositorio 'EstudianteRepositorio' en esta clase para que pueda acceder a sus métodos.
    @Autowired
    EstudianteRepositorio estudianteRepositorio;

    // Método para obtener todos los estudiantes.
    // Utiliza el método 'findAll()' proporcionado por 'EstudianteRepositorio' para obtener una lista de todos los
    // estudiantes en la base de datos.
    public List<Estudiante> obtenerEstudiantes(){
        return (List<Estudiante>) estudianteRepositorio.findAll();
    }

    // Método para obtener un estudiante por su ID.
    // Utiliza el método 'findById()' proporcionado por 'EstudianteRepositorio' para buscar un estudiante específico por su ID.
    public Optional<Estudiante> obtenerEstudiante(Long id){
        return estudianteRepositorio.findById(id);
    }

    // Método para registrar un nuevo estudiante.
    // Utiliza el método 'save()' proporcionado por 'EstudianteRepositorio' para guardar el estudiante en la base de datos.
    public void registrarEstudiante(Estudiante estudiante){
        estudianteRepositorio.save(estudiante);
    }

    // Método para actualizar los datos de un estudiante existente.
    // Utiliza el método 'findById()' para obtener el estudiante actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos del estudiante.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void actualizarEstudiante(Estudiante estudiante, Long id){
        estudianteRepositorio.findById(id)
                .map(estudiante1 -> {
                    estudiante1.setNombre(estudiante.getNombre());
                    estudiante1.setEmail(estudiante.getEmail());
                    estudiante1.setApellido_paterno(estudiante.getApellido_paterno());
                    return estudianteRepositorio.save(estudiante1);
                });
    }

    // Método para borrar un estudiante por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'EstudianteRepositorio' para eliminar el estudiante de la base de datos.
    public void borrarEstudiante(Long id){
        estudianteRepositorio.deleteById(id);
    }

}