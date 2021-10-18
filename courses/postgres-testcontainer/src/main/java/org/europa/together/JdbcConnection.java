package org.europa.together;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

    private final String url = "jdbc:postgresql://localhost/test";
    private final String user = "postgres";
    private final String password = "postgres";

    Connection connection = null;

    public Connection connect(String uri) {
        try {
            connection = DriverManager.getConnection(uri, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException ex) {
            System.err.print(ex.getMessage());
        }
        return connection;
    }

    public ResultSet executeQuery(final String sql) throws SQLException {
        ResultSet resultSet = null;
        if (connection != null) {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            resultSet = statement.getResultSet();
        } else {
            System.err.print("No JDBC Connection established.");
        }
        return resultSet;
    }
}
