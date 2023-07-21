package com.example.ApiRest.Servicios;

import com.example.ApiRest.Entidades.Maestro;
import com.example.ApiRest.Entidades.Materia;
import com.example.ApiRest.Repositorios.MaestroRepositorio;
import com.example.ApiRest.Repositorios.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Anotación que marca la clase como un bean de servicio de Spring.
// Indica que esta clase contiene la lógica de negocio relacionada con la entidad 'Materia'.
@Service
public class MateriaServicio {

    // @Autowired: Anotación que permite la inyección de dependencias automáticamente.
    // Inyecta el bean de repositorio 'MateriaRepositorio' en esta clase para que pueda acceder a sus métodos.
    @Autowired
    MateriaRepositorio materiaRepositorio;

    // Método para obtener todas las materias.
    // Utiliza el método 'findAll()' proporcionado por 'MateriaRepositorio' para obtener una lista de todas las
    // materias en la base de datos.
    public List<Materia> obtenerMaterias(){
        return (List<Materia>) materiaRepositorio.findAll();
    }

    // Método para obtener una materia por su ID.
    // Utiliza el método 'findById()' proporcionado por 'MateriaRepositorio' para buscar una materia específica por su ID.
    public Optional<Materia> obtenerMateria(Long id){
        return materiaRepositorio.findById(id);
    }

    // Método para registrar una nueva materia.
    // Utiliza el método 'save()' proporcionado por 'MateriaRepositorio' para guardar la materia en la base de datos.
    public void registrarMateria(Materia materia){
        materiaRepositorio.save(materia);
    }

    // Método para actualizar los datos de una materia existente.
    // Utiliza el método 'findById()' para obtener la materia actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos de la materia.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void actualizarMateria(Materia materia, Long id){
        materiaRepositorio.findById(id)
                .map(materia1 -> {
                    materia1.setNombre(materia.getNombre());
                    materia1.setHorario(materia.getHorario());
                    materia1.setSalon(materia.getSalon());
                    return materiaRepositorio.save(materia1);
                });
    }

    // Método para borrar una materia por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'MateriaRepositorio' para eliminar la materia de la base de datos.
    public void borrarMateria(Long id){
        materiaRepositorio.deleteById(id);
    }

}