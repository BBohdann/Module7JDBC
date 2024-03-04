package config;

import forProp.PropertyReader;
import storage.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final Database INSTANCE = new Database();
    private static Connection connection;

    static {
        String url = PropertyReader.getConnectionUrlForPostgres();
        String user = PropertyReader.getUserForPostgres();
        String pass = PropertyReader.getPasswordForPostgres();
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(String.format("SQL exception. Can not create connection. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can not create connection.");
        }
    }
    public static int executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can't run query");
        }
    }

    public static <T> List<T> executeQuery(String query, ResultSetMapper<T> mapper) {
        List<T> resultList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                T result = mapper.map(resultSet);
                resultList.add(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Error executing query");
        }
        return resultList;
    }
    private Database() {}

    public static Database getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static String getStringQuery(String filePaths) {
        String query = "";
        try {
            query = Files.readString(Paths.get(filePaths));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return query;
    }
}
