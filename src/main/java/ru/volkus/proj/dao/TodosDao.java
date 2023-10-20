package ru.volkus.proj.dao;

import org.springframework.stereotype.Component;
import ru.volkus.proj.models.Todo;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodosDao {
    private List<Todo> todos;
    private static int TODO_ID;

    {
       todos = new ArrayList<>();
       todos.add(new Todo(++TODO_ID, "To do task1", "task1"));
       todos.add(new Todo(++TODO_ID, "To do task2", "task2"));
       todos.add(new Todo(++TODO_ID, "To do task3", "task3"));
       todos.add(new Todo(++TODO_ID, "To do task4", "task4"));
       todos.add(new Todo(++TODO_ID, "To do task5", "task5"));
       todos.add(new Todo(++TODO_ID, "To do task6", "task6"));

    }

    public List<Todo> index() {
        return todos;
    }

    public Todo showTodo(int id) {
        Todo todo = todos.stream().filter(t -> t.getId() == id).findAny().orElse(null);
        return todo;
    }

    public void create(Todo todo) {
        todo.setId(++TODO_ID);
        todos.add(todo);
    }
}
