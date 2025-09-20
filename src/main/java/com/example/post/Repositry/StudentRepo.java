package com.example.post.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.post.Model.StudentModel;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Long> {

}
