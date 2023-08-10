package com.example.ApiRest.Service;

import com.example.ApiRest.Model.Enum.StudentState;
import com.example.ApiRest.Model.Student;
import com.example.ApiRest.Repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;
    @Mock
    private StudentRepository studentRepository;

    private Student student, student2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        student = new Student(1L,"Arturo","Garcia Ibarra","s15120018"
                ,"Sistemas","s15120018@mail.com","4381005070",StudentState.ACTIVE, null);
        student2 = new Student(2L,"Juan","Garcia Perez","s15120019"
                ,"Sistemas","s15120019@mail.com","4381005071",StudentState.ACTIVE, null);

    }

    @Test
    void obtenerEstudiantes() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> result = studentService.findStudents();

        assertEquals(2, result.size());
        assertEquals("Arturo", result.get(0).getName_student());
        assertEquals("Juan", result.get(1).getName_student());

    }

    @Test
    void obtenerEstudiante() {

        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
        Student result = studentService.findStudentById(1L).get();
        assertEquals("Arturo", result.getName_student());

    }

    @Test
    void registrarEstudiante() {

        when(studentRepository.save(any(Student.class))).thenReturn(student);
        Student result = studentService.addStudent(student);

        assertNotNull(result);
        assertEquals(result.getName_student(), "Arturo");
        assertEquals(result.getId(), 1L);


    }

    @Test
    void actualizarEstudiante() {

        Student student2 = new Student();
        student2.setDegree("NewDegree");
        student2.setName_student("NuevoNombre");
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student2));
        studentService.updateStudent(student2, 1L);
        Student result = studentService.findStudentById(1L).get();
        assertEquals("NuevoNombre", result.getName_student());

    }

    @Test
    void borrarEstudiante() {


        Long id_student = 1L;
        studentService.deleteStudentById(id_student);
        verify(studentRepository, times(1)).deleteById(id_student);

    }


}