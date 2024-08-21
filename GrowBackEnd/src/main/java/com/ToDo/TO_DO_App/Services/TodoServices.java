package com.ToDo.TO_DO_App.Services;

import com.ToDo.TO_DO_App.Models.ToDO;
import com.ToDo.TO_DO_App.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServices {

    @Autowired
    private TodoRepository todoRepository;

    public ToDO createTodo(ToDO todo) {
        return todoRepository.save(todo);
    }

    public List<ToDO> getAllTodos() {
        return todoRepository.findAllByOrderByCreatedAtDesc();
    }


public ToDO updateTodoStatus(Long id, Boolean completed) {
    ToDO todo = todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Sorry todo not found"));
    todo.setStatus(completed);
    return todoRepository.save(todo);
}

}
