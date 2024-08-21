package com.ToDo.TO_DO_App.Controller;

import com.ToDo.TO_DO_App.Models.ToDO;
import com.ToDo.TO_DO_App.Services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoServices todoService;

    @PostMapping("/create")
    public ResponseEntity<ToDO> createTodo(@RequestBody ToDO todo) {
        return new ResponseEntity<>(todoService.createTodo(todo), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ToDO>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ToDO> updateTodoStatus(@PathVariable Long id, @RequestParam Boolean status) {
        return ResponseEntity.ok(todoService.updateTodoStatus(id, status));
    }

}
