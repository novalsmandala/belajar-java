package noval.mandala.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReseultSetTest {

    @Test
    void testExecuteQuery() throws SQLException {

        Connection connection = ConnectionUtil.getDataSource().getConnection();

        Statement statement = connection.createStatement();

        String sql = """
                SELECT * FROM customers
                """;

        ResultSet resultSet = statement.executeQuery(sql);

        // result set seperti cursor
        while (resultSet.next()) {

            // iterasi per baris
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");

            System.out.println(
                    "ID : " + id + "\nName : " + name + "\nEmail : " + email +"\n"
            );
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
