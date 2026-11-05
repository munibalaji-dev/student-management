package com.balaji.studentmanagement.controllers;

import com.balaji.studentmanagement.dtos.StudentRequestDto;
import com.balaji.studentmanagement.dtos.StudentResponseDto;
import com.balaji.studentmanagement.models.Student;
import com.balaji.studentmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    /* For example, when a user requests all students:
        1. Controller receives the request.
        2. Controller calls the Service.
        3. Service calls the Repository.
        4. Repository retrieves students from the database.
    Therefore, your controller needs access to StudentService.*/

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto studentRequestDto){ // here, like StudentRequestDto studentRequestDto = new StudentRequestDto();
                                                                                                                            //studentRequestDto.setName("balaji"); like this it sets all data to studentRequestDto.
        return new ResponseEntity<>(studentService.addStudent(studentRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudentById(@PathVariable long id){
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.FOUND);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllCustomers(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudentById(@PathVariable long id, @RequestBody  StudentRequestDto studentRequestDto
    ){
        return new ResponseEntity<>(studentService.updateStudentById(id, studentRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDto> deleteStudentById(@PathVariable long id){
        return new ResponseEntity<>(studentService.deleteStudent(id),HttpStatus.OK);
    }
}
