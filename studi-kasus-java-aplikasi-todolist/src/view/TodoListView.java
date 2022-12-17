package view;

import service.TodoListService;
import util.InputUtil;

public class TodoListView {

    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    public void showTodoList() {
        while (true){
            System.out.println("TODOLIST");
            todoListService.showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = InputUtil.input("Pilih");
            if (input.equals("1")){
                addTodoList();
            }else if (input.equals("2")){
                removeTodoList();
            }else if (input.toLowerCase().equals("x")) {
                break;
            }else{
                System.out.println("Pilihan Tidak diMengerti!");
            }
        }
    }

    public void addTodoList () {
        System.out.println("MENAMBAH TODOLIST");

        var todo = InputUtil.input("Todo (x Jika Batal) ");

        if (!todo.toLowerCase().equals("x")){
            todoListService.addTodoList(todo);
        }
    }

    public void removeTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = InputUtil.input("Todo (x Jika Batal) ");

        if (!number.toLowerCase().equals("x")){
            todoListService.removeTodolist(Integer.valueOf(number));
        }
    }
}
