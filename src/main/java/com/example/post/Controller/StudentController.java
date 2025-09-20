package com.example.post.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.Dto.StudentDto;
import com.example.post.Service.impl.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping()
    public StudentDto postStudent(@RequestBody StudentDto studentDto) {
        return service.postStudent(studentDto);
    }

    @GetMapping()
    public List<StudentDto> getallstudent() {
        return service.getallstudent();
    }

    //getby id
    @GetMapping("/{Id}")
    public StudentDto getByid(@PathVariable Long Id) throws Exception {
        return service.studentGetbyid(Id);

    }

    //delete by id
    @DeleteMapping("/{Id}")
    public StudentDto delByid(@PathVariable Long Id) throws Exception {
        return service.delbyid(Id);

    }

    @PutMapping("/{Id}")
    public StudentDto putbyid(@RequestBody StudentDto studentDto, @PathVariable Long Id) throws Exception {
        return service.Putbyid(studentDto, Id);

    }

}
