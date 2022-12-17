package service;

import entity.TodoList;

public interface TodoListService {

    void showTodoList();

    void addTodoList(String todo);

    void removeTodolist(Integer number);
}
