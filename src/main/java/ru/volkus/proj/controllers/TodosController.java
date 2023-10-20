package ru.volkus.proj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.volkus.proj.dao.TodosDao;
import ru.volkus.proj.models.Todo;

@Controller
@RequestMapping("/todos")
public class TodosController {
    @Autowired
    private TodosDao todosDao;

//    TodosController(TodosDao todosDao) {
//        this.todosDao = todosDao;
//    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("todos", todosDao.index());
        return "todos/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        Todo todo = todosDao.showTodo(id);
        model.addAttribute("todo", todo);
        return "todos/todo";
    }

    @GetMapping("/new")
    public String newTodo(Model model) {
        model.addAttribute("todo", new Todo());
        return "todos/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("todo") Todo todo) {
        todosDao.create(todo);
        return "redirect: /todos";
    }
}
