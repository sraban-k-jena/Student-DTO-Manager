package com.jt.mapper_dto.service;

import java.util.List;

import com.jt.mapper_dto.dto.StudentDTO;

public interface StudentService {

    StudentDTO addaStudentDTO(StudentDTO studentDTO);

    StudentDTO updateStudentDTO(int id, StudentDTO studentDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO getStudent(int id);

    StudentDTO updatePrice(int id, double price);

    void deleteAllStudent();

    void deleteStudent(int id);
}
