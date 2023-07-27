package com.example.ApiRest.Controladores;

import com.example.ApiRest.Controladores.ManejoExcepciones.MaestroNoEncontrado;
import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Entidades.Maestro;
import com.example.ApiRest.Servicios.MaestroServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/maestros")
@Api(tags = "MaestroControlador", description = "Endpoints para administrar Maestros")
public class MaestroControlador {

    // @Autowired: Inyecta automáticamente una instancia de MaestroServicio en el controlador.
    @Autowired
    private final MaestroServicio maestroServicio;

    // Constructor que recibe una instancia de MaestroServicio y la asigna al atributo maestroServicio.
    public MaestroControlador(MaestroServicio maestroServicio) {
        this.maestroServicio = maestroServicio;
    }

    // @GetMapping: Mapea el método obtenerMaestros() a la ruta /maestro y responde a solicitudes GET.
    // Llama a maestroServicio.obtenerMaestros() para obtener todos los maestros.
    @GetMapping
    @ApiOperation("Obtener todos los maestros registrados")
    public List<Maestro> obtenerMaestros(){

        return maestroServicio.obtenerMaestros();

    }

    // @GetMapping: Mapea el método obtenerMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a maestroServicio.obtenerMaestro(id) para obtener un maestro por su ID.
    @GetMapping("/{id_maestro}")
    @ApiOperation("Obtener la informacion un maestro mediante su id")
    public Maestro obtenerMaestro(
            @ApiParam(value = "id_maestro", required = true)
            @PathVariable Long id){
        return maestroServicio.obtenerMaestro(id).orElseThrow(() -> new MaestroNoEncontrado(id));
    }

    // @PostMapping: Mapea el método registrarMaestro() a la ruta /maestro y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Maestro del cuerpo de la solicitud HTTP.
    // Llama a maestroServicio.registrarMaestro(maestro) para registrar un nuevo maestro.
    @PostMapping
    @ApiOperation("Registra un nuevo maestro")
    public void registrarMaestro(
            @ApiParam(value = "datos del nuevo maestro", required = true)
            @Valid @RequestBody Maestro maestro){
        maestroServicio.registrarMaestro(maestro);
    }

    // @PutMapping: Mapea el método actualizarMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a maestroServicio.actualizarMaestro(maestro, id) para actualizar un maestro existente.
    @PutMapping("/{id_maestro}")
    @ApiOperation("Edita los datos de un maestro mediante su id")
    public void actualizarMaestro(
            @ApiParam(value = "datos nuevos del maestro", required = true)
            @Valid @RequestBody Maestro maestro,
            @ApiParam(value = "id_maestro", required = true)
            @PathVariable Long id){
        maestroServicio.actualizarMaestro(maestro, id);
    }

    // @DeleteMapping: Mapea el método borrarMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a maestroServicio.borrarMaestro(id) para borrar un maestro por su ID.
    @DeleteMapping("/{id_maestro}")
    @ApiOperation("Elimina un maestro mediante su id")
    public void borrarMaestro(
            @ApiParam(value = "id_maestro", required = true)
            @PathVariable Long id){
        maestroServicio.borrarMaestro(id);
    }
}