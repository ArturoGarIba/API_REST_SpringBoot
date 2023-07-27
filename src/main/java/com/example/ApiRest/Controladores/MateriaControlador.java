package com.example.ApiRest.Controladores;

import com.example.ApiRest.Controladores.ManejoExcepciones.MateriaNoEncontrada;
import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Entidades.Materia;
import com.example.ApiRest.Servicios.EstudianteServicio;
import com.example.ApiRest.Servicios.MateriaServicio;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/materias")
@Api(tags = "MateriaControlador", description = "Endpoints para administrar Materias")
public class MateriaControlador {

    @Autowired
    private final MateriaServicio materiaServicio;
    @Autowired
    private final EstudianteServicio estudianteServicio;
    // Constructor que recibe una instancia del servicio MateriaServicio y la asigna al atributo materiaServicio.
    public MateriaControlador(MateriaServicio materiaServicio, EstudianteServicio estudianteServicio) {
        this.materiaServicio = materiaServicio;
        this.estudianteServicio = estudianteServicio;
    }

    // @GetMapping: Mapea el método obtenerMaestros() a la ruta /materia y responde a solicitudes GET.
    // Llama a materiaServicio.obtenerMaterias() para obtener todas las materias.
    @GetMapping
    @ApiOperation("Obtener todas las materias registradas")
    public List<Materia> obtenerMaterias(){
        return materiaServicio.obtenerMaterias();
    }

    // @GetMapping: Mapea el método obtenerMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a materiaServicio.obtenerMateria(id) para obtener una materia por su ID.
    @GetMapping("/{id_maestro}")
    @ApiOperation("Obtener una materia mediante su id")
    public Materia obtenerMateria(
            @ApiParam(value = "id_materia", required = true)
            @PathVariable Long id){
        return materiaServicio.obtenerMateria(id).orElseThrow(() -> new MateriaNoEncontrada(id));
    }

    // @PostMapping: Mapea el método registrarMaestro() a la ruta /materia y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Materia del cuerpo de la solicitud HTTP.
    // Llama a materiaServicio.registrarMateria(materia) para registrar una nueva materia.


    @PostMapping("/materias")
    @ApiOperation("Registrar una nueva materia")
    public void registrarMateria(
           @Valid @RequestBody Materia materia) {
        materiaServicio.registrarMateria(materia);
//        return ResponseEntity.ok();
    }

    // @PutMapping: Mapea el método actualizarMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a materiaServicio.actualizarMateria(materia, id) para actualizar una materia existente.
    @PutMapping("/{id_materia}")
    @ApiOperation("Edita los datos de una materia mediante su id")
    public void actualizarMateria(
            @ApiParam(value = "datos nuevos de la materia", required = true)
            @Valid @RequestBody Materia materia,
            @ApiParam(value = "id_materia", required = true)
            @PathVariable Long id){
        materiaServicio.actualizarMateria(materia, id);
    }

    // @DeleteMapping: Mapea el método borrarMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a materiaServicio.borrarMateria(id) para borrar una materia por su ID.
    @DeleteMapping("/{id_materia}")
    @ApiOperation("Elimina una materia mediante su id")
    public void borrarMateria(
            @ApiParam(value = "id_materia", required = true)
            @PathVariable Long id){
        materiaServicio.borrarMateria(id);
    }
}
