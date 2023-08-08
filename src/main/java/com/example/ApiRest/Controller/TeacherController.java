package com.example.ApiRest.Controller;

import com.example.ApiRest.Controller.ErrorHandler.TeacherNotFound;
import com.example.ApiRest.Model.Teacher;
import com.example.ApiRest.Service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/maestros")
@Api(tags = "MaestroControlador", description = "Endpoints para administrar Maestros")
public class TeacherController {

    // @Autowired: Inyecta automáticamente una instancia de MaestroServicio en el controlador.
    @Autowired
    private final TeacherService teacherService;

    // Constructor que recibe una instancia de MaestroServicio y la asigna al atributo maestroServicio.
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    // @GetMapping: Mapea el método obtenerMaestros() a la ruta /maestro y responde a solicitudes GET.
    // Llama a maestroServicio.obtenerMaestros() para obtener todos los maestros.
    @GetMapping
    @ApiOperation("Obtener todos los maestros registrados")
    public List<Teacher> obtenerMaestros(){

        return teacherService.obtenerMaestros();

    }

    // @GetMapping: Mapea el método obtenerMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a maestroServicio.obtenerMaestro(id) para obtener un maestro por su ID.
    @GetMapping("/{id_maestro}")
    @ApiOperation("Obtener la informacion un maestro mediante su id")
    public Teacher obtenerMaestro(
            @ApiParam(value = "id_maestro", required = true)
            @PathVariable Long id_maestro){
        return teacherService.obtenerMaestro(id_maestro).orElseThrow(() -> new TeacherNotFound(id_maestro));
    }

    // @PostMapping: Mapea el método registrarMaestro() a la ruta /maestro y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Maestro del cuerpo de la solicitud HTTP.
    // Llama a maestroServicio.registrarMaestro(maestro) para registrar un nuevo maestro.
    @PostMapping
    @ApiOperation("Registra un nuevo maestro")
    public void registrarMaestro(
            @ApiParam(value = "datos del nuevo maestro", required = true)
            @Valid
            @RequestBody Teacher teacher){
        teacherService.registrarMaestro(teacher);
    }

    // @PutMapping: Mapea el método actualizarMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a maestroServicio.actualizarMaestro(maestro, id) para actualizar un maestro existente.
    @PutMapping("/{id_maestro}")
    @ApiOperation("Edita los datos de un maestro mediante su id")
    public void actualizarMaestro(
            @ApiParam(value = "datos nuevos del maestro", required = true)
            @Valid @RequestBody Teacher teacher,
            @ApiParam(value = "id_maestro", required = true)
            @PathVariable Long id_maestro){
        teacherService.actualizarMaestro(teacher, id_maestro);
    }

    // @DeleteMapping: Mapea el método borrarMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a maestroServicio.borrarMaestro(id) para borrar un maestro por su ID.
    @DeleteMapping("/{id_maestro}")
    @ApiOperation("Elimina un maestro mediante su id")
    public void borrarMaestro(
            @ApiParam(value = "id_maestro", required = true)
            @PathVariable Long id_maestro){
        teacherService.borrarMaestro(id_maestro);
    }
}