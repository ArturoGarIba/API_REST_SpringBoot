package com.example.ApiRest.Servicios;

import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Entidades.Maestro;
import com.example.ApiRest.Repositorios.EstudianteRepositorio;
import com.example.ApiRest.Repositorios.MaestroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Service: Anotación que marca la clase como un bean de servicio de Spring.
// Indica que esta clase contiene la lógica de negocio relacionada con la entidad 'Maestro'.
@Service
public class MaestroServicio {

    // @Autowired: Anotación que permite la inyección de dependencias automáticamente.
    // Inyecta el bean de repositorio 'MaestroRepositorio' en esta clase para que pueda acceder a sus métodos.
    @Autowired
    MaestroRepositorio maestroRepositorio;

    // Método para obtener todos los maestros.
    // Utiliza el método 'findAll()' proporcionado por 'MaestroRepositorio' para obtener una lista de todos los
    // maestros en la base de datos.
    public List<Maestro> obtenerMaestros(){
        return (List<Maestro>) maestroRepositorio.findAll();
    }

    // Método para obtener un maestro por su ID.
    // Utiliza el método 'findById()' proporcionado por 'MaestroRepositorio' para buscar un maestro específico por su ID.
    public Optional<Maestro> obtenerMaestro(Long id){
        return maestroRepositorio.findById(id);
    }

    // Método para registrar un nuevo maestro.
    // Utiliza el método 'save()' proporcionado por 'MaestroRepositorio' para guardar el maestro en la base de datos.
    public void registrarMaestro(Maestro maestro){
        maestroRepositorio.save(maestro);
    }

    // Método para actualizar los datos de un maestro existente.
    // Utiliza el método 'findById()' para obtener el maestro actual por su ID.
    // Luego, utiliza el método 'map()' para realizar la actualización de los datos del maestro.
    // Después de realizar la actualización, se utiliza nuevamente el método 'save()' para guardar los cambios en la base de datos.
    public void actualizarMaestro(Maestro maestro, Long id){
        maestroRepositorio.findById(id)
                .map(maestro1 -> {
                    maestro1.setNombre(maestro.getNombre());
                    maestro1.setEmail(maestro.getEmail());
                    maestro1.setApellido_paterno(maestro.getApellido_paterno());
                    maestro1.setDireccion(maestro.getDireccion());
                    maestro1.setTelefono(maestro.getTelefono());
                    return maestroRepositorio.save(maestro1);
                });
    }

    // Método para borrar un maestro por su ID.
    // Utiliza el método 'deleteById()' proporcionado por 'MaestroRepositorio' para eliminar el maestro de la base de datos.
    public void borrarMaestro(Long id){
        maestroRepositorio.deleteById(id);
    }

}