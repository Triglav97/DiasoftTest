package com.example.diasoft.controller;

import com.example.diasoft.entity.ToDoEntity;
import com.example.diasoft.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService todoService;

    @PostMapping
    public ResponseEntity createToDo(@RequestBody ToDoEntity todo,
                                     @RequestParam Long userid) {
        try {
            return ResponseEntity.ok(todoService.createToDo(todo, userid));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PutMapping
    public ResponseEntity completeToDo(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(todoService.completeToDo(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
