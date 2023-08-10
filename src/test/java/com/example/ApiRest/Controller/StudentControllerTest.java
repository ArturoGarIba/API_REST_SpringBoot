package com.example.ApiRest.Controller;

import com.example.ApiRest.Model.Enum.StudentState;
import com.example.ApiRest.Model.Student;
import com.example.ApiRest.Service.StudentService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;
//    @Autowired

    @MockBean
    StudentService studentService;
//    @Autowired
    private MockMvc mockMvc;

    private Student student, student2;

    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

        student = new Student(1L,"Arturo","Garcia Ibarra","s15120018"
                ,"Sistemas","s15120018@mail.com","4381005070", StudentState.ACTIVE, null);
        student2 = new Student(2L,"Juan","Garcia Perez","s15120019"
                ,"Ambiental","s15120019@mail.com","4381005071",StudentState.ACTIVE, null);

    }

    @Test
    void obtenerEstudiantes() throws Exception{
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        when(studentService.findStudents()).thenReturn(studentList);

//        mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].nombre_alumno").value("Arturo"))
//                .andExpect(jsonPath("$[0].carrera").value("Sistemas"))
//                .andExpect(jsonPath("$[1].nombre_alumno").value("Juan"))
//                .andExpect(jsonPath("$[1].carrera").value("Ambiental"));

    }

    @Test
    void obtenerEstudiante() throws Exception {



        when(studentService.findStudentById(1L)).thenReturn(Optional.of(student));
        mockMvc.perform(get("/api/students/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre_alumno").value("Arturo"))
                .andExpect(jsonPath("$[0].carrera").value("Sistemas"));
    }

    @Test
    void registrarEstudiante() {



    }

    @Test
    void actualizarEstudiante() {
    }

    @Test
    void borrarEstudiante() {
    }
}