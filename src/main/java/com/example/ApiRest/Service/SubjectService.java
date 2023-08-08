package com.example.ApiRest.Service;

import com.example.ApiRest.Model.Subject;
import com.example.ApiRest.Repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Anotación que marca la clase como un bean de servicio de Spring.
// Indica que esta clase contiene la lógica de negocio relacionada con la entidad 'Materia'.
@Service
public class SubjectService {

    // @Autowired: Anotación que permite la inyección de dependencias automáticamente.
    // Inyecta el bean de repositorio 'MateriaRepositorio' en esta clase para que pueda acceder a sus métodos.
    @Autowired
    SubjectRepository subjectRepository;

    // Método para obtener todas las materias.
    // Utiliza el método 'findAll()' proporcionado por 'MateriaRepositorio' para obtener una lista de todas las
    // materias en la base de datos.
    public List<Subject> obtenerMaterias(){
        return (List<Subject>) subjectRepository.findAll();
    }

    // Método para obtener una materia por su ID.
    // Utiliza el método 'findById()' proporcionado por 'MateriaRepositorio' para buscar una materia específica por su ID.
    public Optional<Subject> obtenerMateria(Long id){
        return subjectRepository.findById(id);
    }

    // Método para registrar una nueva materia.
    // Utiliza el método 'save()' proporcionado por 'MateriaRepositorio' para guardar la materia en la base de datos.
    public Subject registrarMateria(Subject subject){
        return subjectRepository.save(subject);
    }

    // Método para actualizar los datos de una materia existente.
    // Utiliza el método 'findById()' para obtener la materia actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos de la materia.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void actualizarMateria(Subject subject, Long id){
        subjectRepository.findById(id)
                .map(subject1 -> {
                    subject1.setNombre(subject.getNombre());
                    subject1.setHorario(subject.getHorario());
                    subject1.setSalon(subject.getSalon());
                    return subjectRepository.save(subject1);
                });
    }

    // Método para borrar una materia por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'MateriaRepositorio' para eliminar la materia de la base de datos.
    public void borrarMateria(Long id){

            subjectRepository.deleteById(id);

    }

}