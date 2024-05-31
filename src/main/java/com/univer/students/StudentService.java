package com.univer.students;

import com.univer.students.model.entity.StudentsEntity;
import com.univer.students.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    private StudentsRepository studentsRepository;

    public StudentsEntity createStudent(StudentsEntity studentsEntity){
        return studentsRepository.save(studentsEntity);
    }

    public StudentsEntity getStudentById(Integer id){
        Optional<StudentsEntity> optionalStudentsEntity = studentsRepository.findById(id);
        return optionalStudentsEntity.get();
    }

    public List<StudentsEntity> getAllStudents(){
        return studentsRepository.findAll();
    }

    public void deleteStudent(Integer id){
        studentsRepository.deleteById(id);
    }
}
