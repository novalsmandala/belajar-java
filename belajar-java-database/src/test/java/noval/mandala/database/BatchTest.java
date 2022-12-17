package noval.mandala.database;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

    @Test
    void testStatement() throws SQLException {

        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO comment(email, comment)" +
                "VALUES ('noavl@test.com', 'hi')";

        for (int i = 0; i < 1000; i++) {
            statement.addBatch(sql);
        }

        statement.executeBatch();

        statement.close();
        connection.close();
    }

    @Test
    void testPreparedStatement() throws SQLException {

            Connection connection = ConnectionUtil.getDataSource().getConnection();
            String sql = "INSERT INTO comment(email, comment) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < 900; i++) {
                preparedStatement.clearParameters();
                preparedStatement.setString(1, "noval@Test.com");
                preparedStatement.setString(2, "Hi!");
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            preparedStatement.close();
            connection.close();

    }
}
