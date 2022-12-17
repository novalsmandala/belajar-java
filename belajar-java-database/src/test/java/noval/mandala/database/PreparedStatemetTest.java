package noval.mandala.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatemetTest {

    @Test
    void testPrepareStatementTest() throws SQLException {

        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String username = "admin";
        String password = "admin";

        String sql = "SELECT * FROM admin WHERE username = ? " +
                "AND password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Berhasil Login : " + resultSet.getString("username"));
        } else {
            System.out.println("Gagal Login : " + resultSet.getString("username"));
        }

        preparedStatement.close();
        connection.close();
    }
}
