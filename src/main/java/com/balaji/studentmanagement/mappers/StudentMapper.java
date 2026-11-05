package com.balaji.studentmanagement.mappers;

import com.balaji.studentmanagement.dtos.StudentRequestDto;
import com.balaji.studentmanagement.dtos.StudentResponseDto;
import com.balaji.studentmanagement.models.Student;

public class StudentMapper {


    public static Student convertRequestDtoToEntity(StudentRequestDto studentRequestDto){

        if(studentRequestDto == null){
            return null;
        }

        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setPhone(studentRequestDto.getPhone());
        student.setAddress(studentRequestDto.getAddress());

        return student;
    }



    public static StudentResponseDto convertEntityToStudentResponseDto(Student student){

        if(student == null){
            return null;
        }


        StudentResponseDto studentResponseDto = new StudentResponseDto();


        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setPhone(student.getPhone());
        studentResponseDto.setAddress(student.getAddress());


        return studentResponseDto;
    }
}
