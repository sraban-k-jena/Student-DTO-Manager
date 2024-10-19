package com.jt.mapper_dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jt.mapper_dto.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
