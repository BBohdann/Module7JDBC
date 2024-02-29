package org.example;

import config.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        String query = insertDB("sql/init_db.sql");
        Database.getInstance().executeUpdate(query);
    }

    public static String insertDB(String filePaths) {
        String query = "";
        try {
            query = Files.readString(Paths.get(filePaths));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return query;
    }
}

