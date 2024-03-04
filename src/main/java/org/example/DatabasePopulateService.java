package org.example;

import config.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        String query = Database.getStringQuery("sql/populate_db.sql");
        Database.getInstance().executeUpdate(query);
    }
}

