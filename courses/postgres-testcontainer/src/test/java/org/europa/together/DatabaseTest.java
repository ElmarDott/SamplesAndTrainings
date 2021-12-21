package org.europa.together;

import java.sql.SQLException;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.testcontainers.containers.PostgreSQLContainer;

@SuppressWarnings("unchecked")
@RunWith(JUnitPlatform.class)
public class DatabaseTest {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:11.1")
            .withDatabaseName("tests-db")
            .withUsername("postgres")
            .withPassword("postgres");

    private final String url = "jdbc:tc:postgresql:11.1:///test-db";
    private final String CREATE_DB = "CREATE TABLE IF NOT EXISTS test (column_01 int, column_02 char(255));";
    private final String INSERT = "INSERT INTO test (column_01, column_02) VALUES (11, 'test entry');";

    @Test
    void connectionTest() {
        JdbcConnection jdbc = new JdbcConnection();
        jdbc.connect(url);

        try {
            jdbc.executeQuery(CREATE_DB);
            jdbc.executeQuery(INSERT);
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }

        System.out.println("org.europa.together.DatabaseTest.connectionTest() successful");
    }
}
