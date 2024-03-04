package org.example;

import config.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabaseInitService {
    public static void main(String[] args) {
        String query = Database.getStringQuery("sql/init_db.sql");
        Database.getInstance().executeUpdate(query);
    }
}

