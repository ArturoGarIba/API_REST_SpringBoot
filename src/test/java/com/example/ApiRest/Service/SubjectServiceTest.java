package com.example.ApiRest.Service;

import com.example.ApiRest.Model.Enum.SubjectState;
import com.example.ApiRest.Model.Student;
import com.example.ApiRest.Model.Subject;
import com.example.ApiRest.Repository.SubjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {

    @InjectMocks
    private SubjectService subjectService;
    @Mock
    private SubjectRepository subjectRepository;

    private Subject subject, subject2;

    @BeforeEach
    void setUp() {

        subject = new Subject(1L,"English","10:00am","A1",
                null, SubjectState.ACTIVE, null);
        subject2 = new Subject(2L,"Spanish","11:00am","A1",
                null, SubjectState.ACTIVE, null);
    }

    @Test
    void obtenerMaterias() {

        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject);
        subjectList.add(subject2);

        when(subjectRepository.findAll()).thenReturn(subjectList);
        List<Subject> result = subjectService.findSubjects();

        assertEquals(2, result.size());
        assertEquals("English", result.get(0).getName());
        assertEquals("Spanish", result.get(1).getName());

    }

    @Test
    void obtenerMateria() {

        Long id_subject = 1L;
        when(subjectRepository.findById(id_subject)).thenReturn(Optional.of(subject));
        Subject result = subjectService.findSubjectById(id_subject).get();
        assertNotNull(result);
        assertEquals("English", result.getName());

    }

    @Test
    void registrarMateria() {

        when(subjectRepository.save(any(Subject.class))).thenReturn(subject);
        Subject result = subjectService.addSubject(subject);

        assertNotNull(result);
        assertEquals(result.getName(), "English");
        assertEquals(result.getId(), 1L);

    }

    @Test
    void actualizarMateria() {

//        Student student2 = new Student();
//        subject.setId(2L);
//        subject.setNombre("NuevoNombre");
        subject2.setName("NuevoNombre");
        when(subjectRepository.findById(1L)).thenReturn(Optional.of(subject));
        subjectService.updateSubject(subject2, 1L);
        Subject result = subjectService.findSubjectById(1L).get();
        assertEquals(subject.getName(), "NuevoNombre");


    }

    @Test
    void borrarMateria() {

        Long id_subject = 31L;
        subjectService.deleteSubject(id_subject);
        verify(subjectRepository, times(1)).deleteById(id_subject);
    }
}