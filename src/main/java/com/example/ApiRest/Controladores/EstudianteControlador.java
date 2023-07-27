package com.example.ApiRest.Controladores;

import com.example.ApiRest.Controladores.ManejoExcepciones.EstudianteNoEncontrado;
import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Servicios.EstudianteServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api/estudiantes")
@Api(tags = "EstudianteControlador", description = "Endpoints para administrar Estudiantes")
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
    @ApiOperation("Obtener todos los estudiantes registrados")
    public List<Estudiante> obtenerEstudiantes(){

        return estudianteServicio.obtenerEstudiantes();
    }

    // @GetMapping: Mapea el método obtenerEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a estudianteServicio.obtenerEstudiante(id) para obtener un estudiante por su ID.
    @GetMapping("/{id_estudiante}")
    @ApiOperation("Obtener la informacion de un estudiante mediante su id")
    public Estudiante obtenerEstudiante(
            @ApiParam(value = "id_estudiante", required = true)
            @PathVariable Long id){

            return estudianteServicio.obtenerEstudiante(id).orElseThrow(() -> new EstudianteNoEncontrado(id));

    }

    // @PostMapping: Mapea el método registrarEstudiante() a la ruta /api/estudiantes y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Estudiante del cuerpo de la solicitud HTTP.
    // Llama a estudianteServicio.registrarEstudiante(estudiante) para registrar un nuevo estudiante.
    @PostMapping
    @ApiOperation("Registra un nuevo estudiante")
    public void registrarEstudiante(
            @ApiParam(value = "datos del nuevo estudiante", required = true)
            @Valid @RequestBody Estudiante estudiante){
        estudianteServicio.registrarEstudiante(estudiante);
    }

    // @PutMapping: Mapea el método actualizarEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a estudianteServicio.actualizarEstudiante(estudiante, id) para actualizar los datos de un estudiante existente.
    @PutMapping("/{id_estudiante}")
    @ApiOperation("Edita los datos de un estudiante mediante su id")
    public void actualizarEstudiante(
            @ApiParam(value = "datos nuevos del estudiante", required = true)
            @Valid @RequestBody Estudiante estudiante,
            @ApiParam(value = "id_estudiante", required = true)
            @PathVariable Long id){
        estudianteServicio.actualizarEstudiante(estudiante, id);
    }

    // @DeleteMapping: Mapea el método borrarEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a estudianteServicio.borrarEstudiante(id) para borrar un estudiante por su ID.
    @DeleteMapping("/{id_estudiante}")
    @ApiOperation("Elimina un estudiante mediante su id")
    public void borrarEstudiante(

            @PathVariable Long id){
        estudianteServicio.borrarEstudiante(id);
    }
}