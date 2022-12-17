package noval.mandala.database;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class DriverTest {

    @Test
    void testRegister() {

        try {
            Driver mysqlDriver = new Driver();
            DriverManager.registerDriver(mysqlDriver);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static class ConnectionPoolTest {


    }

    public static class ResultSetTest {

        @Test
        void testExecuteQuery() throws SQLException {

            Connection connection = ConnectionUtil.getDataSource().getConnection();

            Statement statement = connection.createStatement();

            String sql = """
                    SELECT * FROM customers
                    """;

            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
