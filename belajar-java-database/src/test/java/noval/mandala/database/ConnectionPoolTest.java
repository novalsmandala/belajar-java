package noval.mandala.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() {

        HikariConfig config = new HikariConfig();
        // config database
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database?serverTimezone=Asia/Jakarta");
        config.setUsername("root");
        config.setPassword("");

        // config pool
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(12 * 60_000);

        // membuat connection pool
        try {
            HikariDataSource dataSource = new HikariDataSource(config);
            Connection connection = dataSource.getConnection();
            connection.close(); // mengembalikan koneksi ke hikaricp sisnya di ambil hikari
            dataSource.close(); // close semua koneksi di data source
        } catch (SQLException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testUtil() {

        try {
            Connection connectionUtil = ConnectionUtil.getDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
