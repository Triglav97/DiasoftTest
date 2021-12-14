package com.example.diasoft.model;

import com.example.diasoft.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String name;
    private List<Todo> todos;




    public static User toModel(Optional<UserEntity> entity){
        User model = new User();
        model.setId(entity.get().getUserId());
        model.setName(entity.get().getName());
        model.setTodos(entity.get().getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));
        return model;
    }


//    public User(UserEntity user) {
//        this.id= user.getUserId();
//        this.name = user.getName();
//    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }
}
