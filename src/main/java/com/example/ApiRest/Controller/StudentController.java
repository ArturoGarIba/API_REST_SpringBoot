package com.example.ApiRest.Controller;

import com.example.ApiRest.Controller.ErrorHandler.StudentNotFound;
import com.example.ApiRest.Model.Student;
import com.example.ApiRest.Service.StudentService;
import io.swagger.annotations.*;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/students")
@Api(tags = "StudentController", description = "Endpoints para administrar Estudiantes")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    // Constructor que recibe una instancia del servicio EstudianteServicio y la asigna al atributo estudianteServicio.
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // @GetMapping: Mapea el método obtenerEstudiantes() a la ruta /api/estudiantes y responde a solicitudes GET.
    // Llama a estudianteServicio.obtenerEstudiantes() para obtener todos los estudiantes.
    @GetMapping
    @ApiOperation("Obtener todos los estudiantes registrados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK. Se obtuvieron correctamente los estudiantes", response = Student.class),
            @ApiResponse(code = 400, message = "BAD REQUEST. El servidor no pudo entender la solicitud", response = String.class),
            @ApiResponse(code = 200, message = "INTERNAL SERVER ERROR. Error del servidor, no se pudo procesar la solicitud")
    })
    public List<Student> findStudents(){

        return studentService.findStudents();
    }

    // @GetMapping: Mapea el método obtenerEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes GET.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a estudianteServicio.obtenerEstudiante(id) para obtener un estudiante por su ID.
    @GetMapping("/{id_student}")
    @ApiOperation("Obtener la informacion de un estudiante mediante su id")
    public Student findStudentById(
            @ApiParam(value = "id_student", required = true)
            @PathVariable Long id_student){

            return studentService.findStudentById(id_student).orElseThrow(() -> new StudentNotFound(id_student));

    }

    // @PostMapping: Mapea el método registrarEstudiante() a la ruta /api/estudiantes y responde a solicitudes POST.
    // El parámetro @RequestBody obtiene el objeto Estudiante del cuerpo de la solicitud HTTP.
    // Llama a estudianteServicio.registrarEstudiante(estudiante) para registrar un nuevo estudiante.
    @PostMapping
    @ApiOperation("Registra un nuevo estudiante")
    public void addStudent(
            @ApiParam(value = "datos del nuevo estudiante", required = true)
            @Valid
            @RequestBody Student student){
        studentService.addStudent(student);
    }


    // @PutMapping: Mapea el método actualizarEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes PUT.
    // Los parámetros @RequestBody y @PathVariable funcionan igual que en los métodos anteriores.
    // Llama a estudianteServicio.actualizarEstudiante(estudiante, id) para actualizar los datos de un estudiante existente.
    @PutMapping("/{id_student}")
    @ApiOperation("Edita los datos de un estudiante mediante su id")
    public void updateStudent(
            @ApiParam(value = "datos nuevos del estudiante", required = true)
            @Valid @RequestBody Student student,
            @ApiParam(value = "id_student", required = true)
            @PathVariable Long id_student){
        studentService.updateStudent(student, id_student);
    }

    // @DeleteMapping: Mapea el método borrarEstudiante() a la ruta /api/estudiantes/{id_estudiante} y responde a solicitudes DELETE.
    // El parámetro @PathVariable extrae el valor del ID de la URL.
    // Llama a estudianteServicio.borrarEstudiante(id) para borrar un estudiante por su ID.
    @DeleteMapping("/{id_student}")
    @ApiOperation("Elimina un estudiante mediante su id")
    public void deleteStudentById(@PathVariable Long id_student){

        studentService.deleteStudentById(id_student);

    }
}