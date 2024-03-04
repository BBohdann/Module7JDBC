package org.example;

import config.Database;
import forPreparedQuery.InsertInfoDB;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static forPreparedQuery.InsertInfoDB.*;

public class DatabasePopulateService {
    public static void main(String[] args) throws SQLException {
        insertWorkers();
        insertClients();
        insertProjects();
        insertProjectWorkers();
    }

    public static void insertWorkers() throws SQLException {
        try (PreparedStatement statement = setStatementQuery(InsertInfoDB.PREPARE_STATEMENT_INSERT_WORKER)) {
            Database.executeUpdate(PopulateWorker(statement));
        }
    }

    public static void insertClients() throws SQLException {
        try (PreparedStatement statement = setStatementQuery(InsertInfoDB.PREPARE_STATEMENT_INSERT_CLIENT)) {
            Database.executeUpdate(PopulateClient(statement));
        }
    }

    public static void insertProjects() throws SQLException {
        try (PreparedStatement statement = setStatementQuery(InsertInfoDB.PREPARE_STATEMENT_INSERT_PROJECT)) {
            Database.executeUpdate(PopulateProject(statement));
        }
    }

    public static void insertProjectWorkers() throws SQLException {
        try (PreparedStatement statement = setStatementQuery(InsertInfoDB.PREPARE_STATEMENT_INSERT_PROJECT_WORKER)) {
            Database.executeUpdate(PopulateProjectWorker(statement));
        }
    }

    public static PreparedStatement setStatementQuery(String query) throws SQLException {
        return Database.getConnection().prepareStatement(query);
    }

    public static PreparedStatement PopulateWorker(PreparedStatement statement) throws SQLException {
        statement.setString(1, "John Doe");
        statement.setDate(2, Date.valueOf("1990-05-15"));
        statement.setString(3, "Senior");
        statement.setLong(4, 8000);
        statement.addBatch();

        statement.setString(1, "Bohdan Marcun");
        statement.setDate(2, Date.valueOf("2003-02-03"));
        statement.setString(3, "Middle");
        statement.setLong(4, 1500);
        statement.addBatch();

        statement.setString(1, "Maria Marcun");
        statement.setDate(2, Date.valueOf("1999-06-18"));
        statement.setString(3, "Trainee");
        statement.setLong(4, 650);
        statement.addBatch();

        statement.setString(1, "David Taylor");
        statement.setDate(2, Date.valueOf("1970-12-18"));
        statement.setString(3, "Senior");
        statement.setLong(4, 7000);
        statement.addBatch();

        statement.setString(1, "Olivia Martinez");
        statement.setDate(2, Date.valueOf("1983-04-22"));
        statement.setString(3, "Trainee");
        statement.setLong(4, 950);
        statement.addBatch();

        statement.setString(1, "Michael Lee");
        statement.setDate(2, Date.valueOf("1992-11-12"));
        statement.setString(3, "Junior");
        statement.setLong(4, 1500);
        statement.addBatch();

        statement.setString(1, "Jane Smith");
        statement.setDate(2, Date.valueOf("1985-09-20"));
        statement.setString(3, "Junior");
        statement.setLong(4, 1200);
        statement.addBatch();

        statement.setString(1, "William Anderson");
        statement.setDate(2, Date.valueOf("1987-08-08"));
        statement.setString(3, "Junior");
        statement.setLong(4, 1300);
        statement.addBatch();

        statement.setString(1, "Julia Brain");
        statement.setDate(2, Date.valueOf("1999-06-09"));
        statement.setString(3, "Middle");
        statement.setLong(4, 1800);
        statement.addBatch();

        statement.setString(1, "Roberto Smith");
        statement.setDate(2, Date.valueOf("1998-02-15"));
        statement.setString(3, "Middle");
        statement.setLong(4, 2100);
        statement.addBatch();
        return statement;
    }
    public static PreparedStatement PopulateClient(PreparedStatement statement) throws SQLException {
        statement.setLong(1, 1);
        statement.setString(2, "Emma Thompson");
        statement.addBatch();

        statement.setLong(1, 2);
        statement.setString(2, "Liam Harris");
        statement.addBatch();

        statement.setLong(1, 3);
        statement.setString(2, "Sophia Miller");
        statement.addBatch();

        statement.setLong(1, 4);
        statement.setString(2, "Noah Wilson");
        statement.addBatch();

        statement.setLong(1, 5);
        statement.setString(2, "Olivia Taylor");
        statement.addBatch();

        return statement;
    }
    public static PreparedStatement PopulateProject(PreparedStatement statement) throws SQLException {
        statement.setLong(1, 1);
        statement.setDate(2, Date.valueOf("2023-01-15"));
        statement.setDate(3, Date.valueOf("2024-03-20"));
        statement.addBatch();

        statement.setLong(1, 2);
        statement.setDate(2, Date.valueOf("2022-05-10"));
        statement.setDate(3, Date.valueOf("2023-07-25"));
        statement.addBatch();

        statement.setLong(1, 3);
        statement.setDate(2, Date.valueOf("2022-08-25"));
        statement.setDate(3, Date.valueOf("2023-11-30"));
        statement.addBatch();

        statement.setLong(1, 4);
        statement.setDate(2, Date.valueOf("2023-03-08"));
        statement.setDate(3, Date.valueOf("2023-09-12"));
        statement.addBatch();

        statement.setLong(1, 5);
        statement.setDate(2, Date.valueOf("2022-11-01"));
        statement.setDate(3, Date.valueOf("2024-01-05"));
        statement.addBatch();

        return statement;
    }
    public static PreparedStatement PopulateProjectWorker(PreparedStatement statement) throws SQLException {
        statement.setLong(1, 1);
        statement.setLong(2, 1);
        statement.addBatch();

        statement.setLong(1, 1);
        statement.setLong(2, 2);
        statement.addBatch();

        statement.setLong(1, 2);
        statement.setLong(2, 3);
        statement.addBatch();

        statement.setLong(1, 2);
        statement.setLong(2, 4);
        statement.addBatch();

        statement.setLong(1, 3);
        statement.setLong(2, 5);
        statement.addBatch();

        statement.setLong(1, 3);
        statement.setLong(2, 6);
        statement.addBatch();

        statement.setLong(1, 4);
        statement.setLong(2, 7);
        statement.addBatch();

        statement.setLong(1, 4);
        statement.setLong(2, 8);
        statement.addBatch();

        statement.setLong(1, 5);
        statement.setLong(2, 9);
        statement.addBatch();

        statement.setLong(1, 5);
        statement.setLong(2, 10);
        statement.addBatch();

        return statement;
    }
}

