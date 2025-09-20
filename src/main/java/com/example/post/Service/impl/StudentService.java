package com.example.post.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.post.Dto.StudentDto;
import com.example.post.Model.StudentModel;
import com.example.post.Repositry.StudentRepo;

@Service
public class StudentService {

    @Autowired

    StudentRepo Repo;

    public StudentDto postStudent(StudentDto studentDto) {
        StudentModel studentModel = new StudentModel();
        studentModel.setId(studentDto.getId());
        studentModel.setName(studentDto.getName());
        studentModel.setEmail(studentDto.getEmail());

        /*{functionolty-ppost=save} */
        Repo.save(studentModel);

        StudentDto sDto = new StudentDto(studentModel.getEmail(), studentModel.getId(), studentModel.getName());
        return sDto;

    }

    public List<StudentDto> getallstudent() {

        List<StudentModel> studentModel = Repo.findAll();

        List<StudentDto> studentDto = studentModel.stream().map(i -> new StudentDto(i.getEmail(), i.getId(), i.getName())).toList();
        return studentDto;

    }

    public StudentDto studentGetbyid(Long id) throws Exception {
        Optional<StudentModel> sModel = Repo.findById(id);
        if (sModel.isPresent()) {
            StudentModel studentModel = sModel.get();
            StudentDto studentDto = new StudentDto(studentModel.getEmail(), studentModel.getId(), studentModel.getName());
            return studentDto;
        } else {
            throw new Exception("Student not found with id: " + id);
        }

    }

    public StudentDto delbyid(Long id) throws Exception {
        Optional<StudentModel> student = Repo.findById(id);

        if (student.isPresent()) {
            StudentModel s = student.get();

            Repo.delete(s);

            StudentDto studentDto = new StudentDto(s.getEmail(), s.getId(), s.getName());
            return studentDto;
        } else {
            throw new Exception("id  not found : " + id);
        }

    }

    public StudentDto Putbyid(StudentDto studentDto, Long id) throws Exception {
        Optional<StudentModel> student = Repo.findById(id);

        if (student.isPresent()) {
            StudentModel s = student.get();
            s.setName(studentDto.getName());
            s.setEmail(studentDto.getEmail());

            Repo.save(s);
            StudentDto studentDto1 = new StudentDto(s.getEmail(), s.getId(), s.getName());
            return studentDto1;
        } else {
            throw new Exception("id  not found : " + id);
        }

    }

}
