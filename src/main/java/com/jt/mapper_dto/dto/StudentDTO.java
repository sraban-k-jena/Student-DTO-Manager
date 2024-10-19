package com.jt.mapper_dto.dto;

import com.jt.mapper_dto.constant.StudentType;

import lombok.Data;

@Data
public class StudentDTO {

    private int id;
    private String name;
    private String fatherName;
    private String description;
    private double price;
    private String password;
    private StudentType type;
}
