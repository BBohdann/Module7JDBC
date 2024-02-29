package config;

import forProp.PropertyReader;
import storage.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
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

    private Database() {}

    public static Database getInstance() {
        return INSTANCE;
    }

    public static Connection getConnection() {
        return connection;
    }

    public int executeUpdate(String query) {
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Can't run query");
        }
    }

    public List<MaxProjectCountClient> executeQueryForMaxProjectCountClients(String query) {
        List<MaxProjectCountClient> resultList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int projectCount = resultSet.getInt(2);
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                resultList.add(client);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Error executing query");
        }
        return resultList;
    }

    public List<ProjectPrices> executeQueryForProjectPrices(String query) {
        List<ProjectPrices> resultList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int price = resultSet.getInt(2);
                ProjectPrices client = new ProjectPrices(id, price);
                resultList.add(client);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Error executing query");
        }
        return resultList;
    }
    public List<MaxSalaryWorker> executeQueryForMaxSalaryWorker(String query) {
        List<MaxSalaryWorker> resultList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                int salary = resultSet.getInt(2);
                MaxSalaryWorker client = new MaxSalaryWorker(name,salary);
                resultList.add(client);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Error executing query");
        }
        return resultList;
    }
    

    public List<YoungestEldestWorkers> executeQueryForYoungestEldestWorkers(String query) {
        List<YoungestEldestWorkers> resultList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                String type = resultSet.getString(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);
                LocalDate birthday = date.toLocalDate();

                YoungestEldestWorkers client = new YoungestEldestWorkers(type, name , birthday);
                resultList.add(client);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Error executing query");
        }
        return resultList;
    }
    public List<LongestProject> executeQueryForLongestProject(String query) {
        List<LongestProject> resultList = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int mountsCount = resultSet.getInt(2);
                LongestProject client = new LongestProject(id,mountsCount);
                resultList.add(client);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
            throw new RuntimeException("Error executing query");
        }
        return resultList;
    }
}
