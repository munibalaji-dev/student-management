package com.balaji.studentmanagement.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDto {

    private Integer id;
    private String name;
    private String age;
    private Integer phone;
    private String address;
}