package noval.surya.mandala.todolist;

import com.sun.security.jgss.GSSUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseTest {

    @Test
    void testConnection() throws SQLException {

        HikariDataSource dataSource = DatabaseUtil.dataSource();

        Connection connection = dataSource.getConnection();

        Assertions.assertNotNull(connection);

        System.out.println(connection);

        connection.close();
        dataSource.close();

    }
}
