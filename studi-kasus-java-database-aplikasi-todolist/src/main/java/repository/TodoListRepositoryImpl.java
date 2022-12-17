package repository;

import entity.TodoList;
import service.TodoListServiceImpl;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository{

    public TodoList[] data = new TodoList[10];

    private DataSource dataSource;

    public TodoListRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        
        String sql = "SELECT id,todo FROM todolist";
        
        try (Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {

            List<TodoList> list = new ArrayList<>();
            while (resultSet.next()) {
                TodoList todoList = new TodoList();

                 todoList.setId(resultSet.getInt("id"));
                 todoList.setTodo(resultSet.getString("todo"));

                 list.add(todoList);
            }

            return list.toArray(new TodoList[] {});
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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
       String sql = "INSERT INTO todolist(todo) VALUES (?)";

       try (Connection connection = dataSource.getConnection()) {

           try (PreparedStatement preparedStatement = connection.prepareStatement(sql,
                   Statement.RETURN_GENERATED_KEYS)) {

               preparedStatement.setString(1, todo.getTodo());

               int id = preparedStatement.executeUpdate();

               try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {

               }

           }
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    private boolean isExist(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";

        try(Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, number);

            try (ResultSet resultSet = statement.executeQuery()){

                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean remove(Integer number) {
        String sql = "DELETE FROM todolist WHERE id = ?";

        if (isExist(number)) {

            try (Connection connection = dataSource.getConnection()) {

                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                    preparedStatement.setInt(1, number);

                    int rowAffected = preparedStatement.executeUpdate();

                    return true;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }

    }
}
