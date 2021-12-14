package com.example.diasoft.service;

import com.example.diasoft.entity.ToDoEntity;
import com.example.diasoft.entity.UserEntity;
import com.example.diasoft.model.Todo;
import com.example.diasoft.repository.ToDoRepo;
import com.example.diasoft.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createToDo(ToDoEntity todo, Long userid){
        UserEntity user = userRepo.findById(userid).get();
        todo.setUserid(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo completeToDo(Long id){
        ToDoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
