package com.jt.mapper_dto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jt.mapper_dto.dto.StudentDTO;
import com.jt.mapper_dto.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/student")
@Tag(name = "StudentController", description = "Manage StudentRecord .")
public class StudentController {

    @Autowired
    public StudentService service;

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTO2 = service.addaStudentDTO(studentDTO);
        return new ResponseEntity<>(studentDTO2, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        StudentDTO studentDTO2 = service.updateStudentDTO(id, studentDTO);
        return new ResponseEntity<>(studentDTO2, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        List<StudentDTO> studentDTOs = service.getAllStudents();
        return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getSTudent(@PathVariable int id) {
        StudentDTO studentDTO = service.getStudent(id);
        return new ResponseEntity<>(studentDTO, HttpStatus.OK);
    }

    @PatchMapping("/{id}/update/{price}")
    public ResponseEntity<StudentDTO> updatePrice(@PathVariable int id, @PathVariable double price) {
        StudentDTO studentDTO2 = service.updatePrice(id, price);
        return new ResponseEntity<>(studentDTO2, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        service.deleteAllStudent();
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
