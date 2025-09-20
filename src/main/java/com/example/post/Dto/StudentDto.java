package com.example.post.Dto;

public class StudentDto {

    private long id;
    private String name;
    private String email;

    public StudentDto(String email, long id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
