package com.jt.mapper_dto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.mapper_dto.dto.StudentDTO;
import com.jt.mapper_dto.mapper.StudentMapper;
import com.jt.mapper_dto.model.Student;
import com.jt.mapper_dto.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepo studentRepo;

    @Override
    public StudentDTO addaStudentDTO(StudentDTO studentDTO) {
        Student student = null;
        try {
            student = StudentMapper.convertToStudentDto(studentDTO);
            studentRepo.save(student);
            return StudentMapper.convertToStudent(student);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return studentDTO;

    }

    @Override
    public StudentDTO updateStudentDTO(int id, StudentDTO studentDTO) {
        try {
            if (!studentRepo.existsById(id)) {
                throw new IllegalArgumentException(id + " does not exist .");
            }
            Student student = StudentMapper.convertToStudentDto(studentDTO);
            student.setId(id);
            studentRepo.save(student);
            return StudentMapper.convertToStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {

        List<Student> students = studentRepo.findAll();

        return students.stream().map(StudentMapper::convertToStudent).collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudent(int id) {
        try {
            if (!studentRepo.existsById(id)) {
                throw new IllegalArgumentException(id + " does not exist .");
            }
            Student student = studentRepo.findById(id).get();
            return StudentMapper.convertToStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public StudentDTO updatePrice(int id, double price) {
        try {
            if (!studentRepo.existsById(id)) {
                throw new IllegalArgumentException(id + " does not exist .");
            }
            Student student = studentRepo.findById(id).get();
            student.setPrice(price + student.getPrice());
            studentRepo.save(student);
            return StudentMapper.convertToStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteAllStudent() {
        studentRepo.deleteAll();
    }

    @Override
    public void deleteStudent(int id) {
        try {
            if (!studentRepo.existsById(id)) {
                throw new IllegalArgumentException(id + " does not exist .");
            }
            studentRepo.deleteById(id);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
