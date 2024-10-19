package com.jt.mapper_dto.model;

import com.jt.mapper_dto.constant.StudentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String fatherName;
    private String description;
    private double price;
    private String password;
    @Enumerated(EnumType.STRING)
    private StudentType type;
}
