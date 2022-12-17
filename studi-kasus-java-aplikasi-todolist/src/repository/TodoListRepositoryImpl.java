package repository;

import entity.TodoList;
import service.TodoListServiceImpl;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull () {
        var isFull = true;
        for (int i = 0; i < data.length; i++){
            if (data[i] == null){
                // model masih penuh
                isFull = false;
            }
        }
        return isFull;
    }

    public void resizeIfFull() {
        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull()){
            // mengcopy data dari model ke temporary
            var tmp = data;
            data = new TodoList[data.length * 2];

            // memasukan data dari temporary ke data model yang sudah di resize
            for (int i = 0; i < tmp.length; i++){
                data[i] = tmp[i];
            }
        }

    }

    @Override
    public void add(TodoList todo) {
        resizeIfFull();
        // tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = todo;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if ((number - 1) >= data.length){
            return false;
        }else if (data[number - 1] == null){
            return false;
        }else {
            data[number - 1] = null;

            for (int i = (number - 1); i < data.length; i++){
                if (i == (data.length - 1)){
                    data[i] = null;
                }else{
                    data[i]= data[i + 1];
                }
            }
            return true;
        }
    }
}
