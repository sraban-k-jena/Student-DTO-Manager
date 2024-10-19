package com.jt.mapper_dto.mapper;

import org.springframework.beans.BeanUtils;

import com.jt.mapper_dto.dto.StudentDTO;
import com.jt.mapper_dto.model.Student;

public class StudentMapper {
    public static Student convertToStudentDto(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        return student;
    }

    public static StudentDTO convertToStudent(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        BeanUtils.copyProperties(student, studentDTO);
        return studentDTO;
    }
}
