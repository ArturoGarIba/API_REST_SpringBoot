package com.example.ApiRest.Controller;

import com.example.ApiRest.Controller.ErrorHandler.SubjectNotFound;
import com.example.ApiRest.Model.Subject;
import com.example.ApiRest.Service.StudentService;
import com.example.ApiRest.Service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//import jakarta.validation.Valid;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/subjects")
@Api(tags = "SubjectController", description = "Endpoints para administrar Materias")
public class SubjectController {

    @Autowired
    private final SubjectService subjectService;
    @Autowired
    private final StudentService studentService;
    // Constructor que recibe una instancia del servicio MateriaServicio y la asigna al atributo materiaServicio.
    public SubjectController(SubjectService subjectService, StudentService studentService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
    }

    // @GetMapping: Mapea el método obtenerMaestros() a la ruta /materia y responde a solicitudes GET.
    // Llama a materiaServicio.obtenerMaterias() para obtener todas las materias.
    @GetMapping
    @ApiOperation("Obtener todas las materias registradas")
    public List<Subject> findSubjects(){
        return subjectService.findSubjects();
    }

    // @GetMapping: Mapea el método obtenerMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a materiaServicio.obtenerMateria(id) para obtener una materia por su ID.
    @GetMapping("/{id_subject}")
    @ApiOperation("Obtener una materia mediante su id")
    public Subject findSubjectById(
            @ApiParam(value = "id_subject", required = true)
            @PathVariable Long id_subject){
        return subjectService.findSubjectById(id_subject).orElseThrow(() -> new SubjectNotFound(id_subject));
    }

    // @PostMapping: Mapea el método registrarMaestro() a la ruta /materia y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Materia del cuerpo de la solicitud HTTP.
    // Llama a materiaServicio.registrarMateria(materia) para registrar una nueva materia.


    @PostMapping
    @ApiOperation("Registrar una nueva materia")
    public void registrarMateria(
           @Valid
           @RequestBody Subject subject) {
        subjectService.addSubject(subject);
//        return ResponseEntity.ok();
    }

    // @PutMapping: Mapea el método actualizarMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a materiaServicio.actualizarMateria(materia, id) para actualizar una materia existente.
    @PutMapping("/{id_subject}")
    @ApiOperation("Edita los datos de una materia mediante su id")
    public void updateSubject(
            @ApiParam(value = "datos nuevos de la materia", required = true)
            @Valid @RequestBody Subject subject,
            @ApiParam(value = "id_subject", required = true)
            @PathVariable Long id_subject){
        subjectService.updateSubject(subject, id_subject);
    }

    // @DeleteMapping: Mapea el método borrarMaestro() a la ruta /materia/{id_maestro} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a materiaServicio.borrarMateria(id) para borrar una materia por su ID.
    @DeleteMapping("/{id_subject}")
    @ApiOperation("Elimina una materia mediante su id")
    public void deleteSubject(
            @ApiParam(value = "id_subject", required = true)
            @PathVariable Long id_subject){

        subjectService.deleteSubject(id_subject);

    }
}
