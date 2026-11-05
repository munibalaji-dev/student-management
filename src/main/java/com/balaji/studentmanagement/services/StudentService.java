package com.balaji.studentmanagement.services;

import com.balaji.studentmanagement.dtos.StudentRequestDto;
import com.balaji.studentmanagement.dtos.StudentResponseDto;
import com.balaji.studentmanagement.models.Student;

import java.util.List;

public interface StudentService {

    StudentResponseDto addStudent(StudentRequestDto studentRequestDto);
    StudentResponseDto getStudentById(long id);
    StudentResponseDto updateStudentById(long id, StudentRequestDto studentRequestDto);
    List<Student> getAllStudents();
    StudentResponseDto deleteStudent(long id);

}
