package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService{

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        System.out.println("TODOLIST");

        for (var todolist : model) {
            System.out.println(todolist.getId() + ". " + todolist.getTodo());
        }

    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("SUKSES MENAMBAH " + todoList.getTodo());
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean succes = todoListRepository.remove(number);
        if (succes) System.out.println("SUKSES MENGHAPUS TODO : " + number);
    }
}
