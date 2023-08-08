package com.example.ApiRest.Service;

import com.example.ApiRest.Model.Enum.TeacherState;
import com.example.ApiRest.Model.Student;
import com.example.ApiRest.Model.Teacher;
import com.example.ApiRest.Repository.TeacherRepository;
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
class TeacherServiceTest {

    @InjectMocks
    private TeacherService teacherService;

    @Mock
    private TeacherRepository teacherRepository;

    private Teacher teacher, teacher2;

    @BeforeEach
    void setUp(){

        MockitoAnnotations.openMocks(this);

        teacher = new Teacher(1L, "Teacher1","Garcia","teacher1@mail.com","Jesus Montano #5"
                , "4301110099", TeacherState.ACTIVE);
        teacher2 = new Teacher(2L, "Teacher2","Garcia","teacher2@mail.com","Jesus Montano #6"
                , "4301110088", TeacherState.ACTIVE);

    }

    @Test
    void obtenerMaestros() {

        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(teacher);
        teacherList.add(teacher2);
        when(teacherRepository.findAll()).thenReturn(teacherList);
        List<Teacher> result = teacherService.obtenerMaestros();

        assertEquals(2, result.size());
        assertEquals("Teacher1", result.get(0).getNombre());
        assertEquals("Teacher2", result.get(1).getNombre());

    }

    @Test
    void obtenerMaestro() {

        when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));
        Teacher result = teacherService.obtenerMaestro(1L).get();
        assertNotNull(result);
        assertEquals(result.getNombre(), "Teacher1");

    }

    @Test
    void registrarMaestro() {

        when(teacherRepository.save(any(Teacher.class))).thenReturn(teacher);
        Teacher result = teacherService.registrarMaestro(teacher);

        assertNotNull(result);
        assertEquals(result.getNombre(), "Teacher1");
        assertEquals(result.getId(), 1L);

    }

    @Test
    void actualizarMaestro() {

        Teacher teacher1 = new Teacher();
        teacher1.setId(2L);
        teacher1.setNombre("NewName");
        when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher1));
        teacherService.actualizarMaestro(teacher1, 1L);
        Teacher result = teacherService.obtenerMaestro(1L).get();
        assertEquals(result.getNombre(), "NewName");

    }

    @Test
    void borrarMaestro() {

        Long id_teacher = 1L;
        teacherService.borrarMaestro(id_teacher);
        verify(teacherRepository, times(1)).deleteById(id_teacher);

    }


}