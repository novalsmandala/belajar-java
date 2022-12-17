package noval.mandala.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutoIncrementTest {

    @Test
    void testAutoIncrement() throws SQLException {

        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "INSERT INTO comment(email, comment) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                PreparedStatement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(2, "Hi!");
        preparedStatement.setString(1, "noval@Test.com");

        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();

        if (resultSet.next()) {
            int id = resultSet.getInt(1);
            System.out.println("Id Comment : " + id);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
