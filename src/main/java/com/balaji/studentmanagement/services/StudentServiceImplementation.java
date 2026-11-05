package com.balaji.studentmanagement.services;

import com.balaji.studentmanagement.dtos.StudentRequestDto;
import com.balaji.studentmanagement.dtos.StudentResponseDto;
import com.balaji.studentmanagement.exceptions.StudentNotFoundException;
import com.balaji.studentmanagement.mappers.StudentMapper;
import com.balaji.studentmanagement.models.Student;
import com.balaji.studentmanagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService{

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImplementation(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {

        Student student = StudentMapper.convertRequestDtoToEntity(studentRequestDto);
        Student savedStudent = studentRepository.save(student);

        StudentResponseDto responseDto = StudentMapper.convertEntityToStudentResponseDto(savedStudent);

        return responseDto;
    }

    @Override
    public StudentResponseDto getStudentById(long id) {

        Optional<Student> byId = studentRepository.findById(id);

        Student student = byId.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));


        StudentResponseDto studentResponseDto = StudentMapper.convertEntityToStudentResponseDto(student);

        return studentResponseDto;
    }

    @Override
    public StudentResponseDto updateStudentById(long id, StudentRequestDto studentRequestDto) {

        Optional<Student> byId = studentRepository.findById(id);
        Student student = byId.orElseThrow(() -> new StudentNotFoundException("Id doesn't match with any student to update"));

        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setPhone(studentRequestDto.getPhone());
        student.setAddress(studentRequestDto.getAddress());

        Student save = studentRepository.save(student);

        StudentResponseDto studentResponseDto = StudentMapper.convertEntityToStudentResponseDto(save);

        return studentResponseDto;
    }

    @Override
    public List<Student> getAllStudents() {

        List<Student> allStudents = studentRepository.findAll();

        return allStudents;
    }

    @Override
    public StudentResponseDto deleteStudent(long id) {

        Optional<Student> byId = studentRepository.findById(id);

        Student student = byId.orElseThrow(()-> new StudentNotFoundException("Id not found to delete the student"));


        studentRepository.delete(student);

        return null;
    }
}
