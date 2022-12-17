package noval.mandala.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTest {

    @Test
    void testCommit() throws SQLException {

        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO comment(email, comment) VALUES (?, ?)";

        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "noval@Test.com");
            preparedStatement.setString(2, "Hi!");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        // jika data berhasil semua maka semua data akan di commit
        // jika salah satu atau lebih proses gagal maka semua proses akan di gagalkan
        connection.commit();
        connection.close();
    }

    @Test
    void testRollback() throws SQLException {

        Connection connection = ConnectionUtil.getDataSource().getConnection();
        connection.setAutoCommit(false);

        String sql = "INSERT INTO comment(email, comment) VALUES (?, ?)";

        for (int i = 0; i < 100; i++) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "noval@Test.com");
            preparedStatement.setString(2, "Hi!");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }

        // rollback digunakan untuk membatalkan seluruh transaksi
        connection.rollback();
        // jika data berhasil semua maka semua data akan di commit
        // jika salah satu atau lebih proses gagal maka semua proses akan di gagalkan
        connection.commit();
        connection.close();
    }
}
