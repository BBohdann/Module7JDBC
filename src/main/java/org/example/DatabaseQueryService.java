package org.example;
import config.Database;
import mapper.*;
import storage.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static config.Database.executeQuery;

public class DatabaseQueryService {
    public static List<storage.MaxProjectCountClient> clients = new ArrayList<>();
    public static List<storage.ProjectPrices> projectPrices = new ArrayList<>();
    public static List<storage.MaxSalaryWorker> maxSalary = new ArrayList<>();
    public static List<storage.YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
    public static List<storage.LongestProject> longestProgect = new ArrayList<>();

    public static void main(String[] args) {
        clients = executeQuery(Database.getStringQuery("sql/find_max_projects_client.sql"), new MaxProjectCountClientMapper());
        System.out.println("--------------- Clients ---------------");
        for (MaxProjectCountClient client : clients) {
            System.out.println(client);
        }
        System.out.println("---------------------------------------");

        projectPrices = executeQuery(Database.getStringQuery("sql/print_project_prices.sql"), new ProjectPricesMapper());
        System.out.println("-------------- Prices -----------------");
        for (ProjectPrices price : projectPrices) {
            System.out.println(price);
        }
        System.out.println("---------------------------------------");

        maxSalary = executeQuery(Database.getStringQuery("sql/find_max_salary_worker.sql"), new MaxSalaryWorkerMapper());
        System.out.println("-------------- Salary -----------------");
        for (MaxSalaryWorker worker : maxSalary) {
            System.out.println(worker);
        }
        System.out.println("---------------------------------------");

        youngestEldestWorkers = executeQuery(Database.getStringQuery("sql/find_youngest_eldest_workers.sql"), new YoungestEldestWorkersMapper());
        System.out.println("------------- Workers -----------------");
        for (YoungestEldestWorkers worker : youngestEldestWorkers) {
            System.out.println(worker);
        }
        System.out.println("---------------------------------------");

        longestProgect = executeQuery(Database.getStringQuery("sql/find_longest_project.sql"), new LongestProjectMapper());
        System.out.println("------------ Longest Projects ---------");
        for (LongestProject project : longestProgect) {
            System.out.println(project);
        }
        System.out.println("---------------------------------------");
    }
}
