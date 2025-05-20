package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists= studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student with student id; "+ id + " does not exist");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email){
        Optional<Student> studentOptional= studentRepository.findById(id);
        if(studentOptional.isEmpty()){
            throw new IllegalStateException("Student doesnt exist with id: "+ id);
        }
        Student student= studentOptional.get();
        if(name!=null){
            student.setName(name);
        }
        if(email!=null){
            student.setEmail(email);
        }
    }
}
