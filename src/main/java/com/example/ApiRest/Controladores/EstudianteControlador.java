package com.example.ApiRest.Controladores;

import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/estudiantes")
public class EstudianteControlador {

    @Autowired
    private final EstudianteServicio estudianteServicio;

    // Constructor que recibe una instancia del servicio EstudianteServicio y la asigna al atributo estudianteServicio.
    public EstudianteControlador(EstudianteServicio estudianteServicio) {
        this.estudianteServicio = estudianteServicio;
    }

    // @GetMapping: Mapea el método obtenerEstudiantes() a la ruta /api/estudiantes y responde a solicitudes GET.
    // Llama a estudianteServicio.obtenerEstudiantes() para obtener todos los estudiantes.
    @GetMapping
    public List<Estudiante> obtenerEstudiantes(){
        return estudianteServicio.obtenerEstudiantes();
    }

    // @GetMapping: Mapea el método obtenerEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a estudianteServicio.obtenerEstudiante(id) para obtener un estudiante por su ID.
    @GetMapping("/{id_estudiante}")
    public Optional<Estudiante> obtenerEstudiante(@PathVariable Long id){
        return estudianteServicio.obtenerEstudiante(id);
    }

    // @PostMapping: Mapea el método registrarEstudiante() a la ruta /api/estudiantes y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Estudiante del cuerpo de la solicitud HTTP.
    // Llama a estudianteServicio.registrarEstudiante(estudiante) para registrar un nuevo estudiante.
    @PostMapping
    public void registrarEstudiante(@RequestBody Estudiante estudiante){
        estudianteServicio.registrarEstudiante(estudiante);
    }

    // @PutMapping: Mapea el método actualizarEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a estudianteServicio.actualizarEstudiante(estudiante, id) para actualizar los datos de un estudiante existente.
    @PutMapping("/{id_estudiante}")
    public void actualizarEstudiante(@RequestBody Estudiante estudiante, @PathVariable Long id){
        estudianteServicio.actualizarEstudiante(estudiante, id);
    }

    // @DeleteMapping: Mapea el método borrarEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a estudianteServicio.borrarEstudiante(id) para borrar un estudiante por su ID.
    @DeleteMapping("/{id_estudiante}")
    public void borrarEstudiante(@PathVariable Long id){
        estudianteServicio.borrarEstudiante(id);
    }
}