package com.example.ApiRest.Controladores;

import com.example.ApiRest.Entidades.Estudiante;
import com.example.ApiRest.Entidades.Maestro;
import com.example.ApiRest.Servicios.MaestroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/maestro")
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
    public List<Maestro> obtenerMaestros(){
        return maestroServicio.obtenerMaestros();
    }

    // @GetMapping: Mapea el método obtenerMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a maestroServicio.obtenerMaestro(id) para obtener un maestro por su ID.
    @GetMapping("/{id_maestro}")
    public Optional<Maestro> obtenerMaestro(@PathVariable Long id){
        return maestroServicio.obtenerMaestro(id);
    }

    // @PostMapping: Mapea el método registrarMaestro() a la ruta /maestro y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Maestro del cuerpo de la solicitud HTTP.
    // Llama a maestroServicio.registrarMaestro(maestro) para registrar un nuevo maestro.
    @PostMapping
    public void registrarMaestro(@RequestBody Maestro maestro){
        maestroServicio.registrarMaestro(maestro);
    }

    // @PutMapping: Mapea el método actualizarMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a maestroServicio.actualizarMaestro(maestro, id) para actualizar un maestro existente.
    @PutMapping("/{id_maestro}")
    public void actualizarMaestro(@RequestBody Maestro maestro, @PathVariable Long id){
        maestroServicio.actualizarMaestro(maestro, id);
    }

    // @DeleteMapping: Mapea el método borrarMaestro() a la ruta /maestro/{id_maestro} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a maestroServicio.borrarMaestro(id) para borrar un maestro por su ID.
    @DeleteMapping("/{id_maestro}")
    public void borrarMaestro(@PathVariable Long id){
        maestroServicio.borrarMaestro(id);
    }
}