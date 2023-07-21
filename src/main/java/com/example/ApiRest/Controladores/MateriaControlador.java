package com.example.ApiRest.Controladores;

import com.example.ApiRest.Entidades.Maestro;
import com.example.ApiRest.Entidades.Materia;
import com.example.ApiRest.Servicios.MateriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/materia")
public class MateriaControlador {

    @Autowired
    private final MateriaServicio materiaServicio;

    // Constructor que recibe una instancia del servicio MateriaServicio y la asigna al atributo materiaServicio.
    public MateriaControlador(MateriaServicio materiaServicio) {
        this.materiaServicio = materiaServicio;
    }

    // @GetMapping: Mapea el método obtenerMaestros() a la ruta /materia y responde a solicitudes GET.
    // Llama a materiaServicio.obtenerMaterias() para obtener todas las materias.
    @GetMapping
    public List<Materia> obtenerMaestros(){
        return materiaServicio.obtenerMaterias();
    }

    // @GetMapping: Mapea el método obtenerMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a materiaServicio.obtenerMateria(id) para obtener una materia por su ID.
    @GetMapping("/{id_maestro}")
    public Optional<Materia> obtenerMaestro(@PathVariable Long id){
        return materiaServicio.obtenerMateria(id);
    }

    // @PostMapping: Mapea el método registrarMaestro() a la ruta /materia y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Materia del cuerpo de la solicitud HTTP.
    // Llama a materiaServicio.registrarMateria(materia) para registrar una nueva materia.
    @PostMapping
    public void registrarMaestro(@RequestBody Materia materia){
        materiaServicio.registrarMateria(materia);
    }

    // @PutMapping: Mapea el método actualizarMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a materiaServicio.actualizarMateria(materia, id) para actualizar una materia existente.
    @PutMapping("/{id_maestro}")
    public void actualizarMaestro(@RequestBody Materia materia, @PathVariable Long id){
        materiaServicio.actualizarMateria(materia, id);
    }

    // @DeleteMapping: Mapea el método borrarMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a materiaServicio.borrarMateria(id) para borrar una materia por su ID.
    @DeleteMapping("/{id_maestro}")
    public void borrarMaestro(@PathVariable Long id){
        materiaServicio.borrarMateria(id);
    }
}
