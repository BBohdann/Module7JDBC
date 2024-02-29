package org.example;
import config.Database;
import storage.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static final List<storage.MaxProjectCountClient> clients = new ArrayList<>();
    public static final List<storage.ProjectPrices> projectPrices = new ArrayList<>();
    public static final List<storage.MaxSalaryWorker> maxSalary = new ArrayList<>();
    public static final List<storage.YoungestEldestWorkers> youngestEldestWorkers = new ArrayList<>();
    public static final List<storage.LongestProject> longestProgect = new ArrayList<>();

    public static void main(String[] args) {
        for (MaxProjectCountClient maxProjectCountClient : findMaxProjectsClient() ){
            System.out.println(maxProjectCountClient);
        }
        System.out.println(" --------------------------------------------------------------");
        for (ProjectPrices projectPrices : findProjectPrices() ){
            System.out.println(projectPrices);
        }
        System.out.println(" --------------------------------------------------------------");
        for (MaxSalaryWorker maxSalaryWorker : findMaxSalaryWorker() ){
            System.out.println(maxSalary);
        }
        System.out.println(" --------------------------------------------------------------");
        for (YoungestEldestWorkers youngestEldestWorker : findYougestEldestWorkers() ){
            System.out.println(youngestEldestWorker);
        }
        System.out.println(" --------------------------------------------------------------");
        for (LongestProject l : findLongestProject() ){
            System.out.println(l);
        }
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



    public static List<MaxProjectCountClient> findMaxProjectsClient(){
        String querySelect = insertDB("sql/find_max_projects_client.sql");
        List<MaxProjectCountClient> result = Database.getInstance().executeQueryForMaxProjectCountClients(querySelect);

        for (MaxProjectCountClient o : result) {
            clients.add(o);
        }
        return clients;
    }

    public static List<ProjectPrices> findProjectPrices(){
        String querySelect = insertDB("sql/print_project_prices.sql");
        List<ProjectPrices> result = Database.getInstance().executeQueryForProjectPrices(querySelect);

        for (ProjectPrices pp : result) {
            projectPrices.add(pp);
        }
        return projectPrices;
    }

    public static List<MaxSalaryWorker> findMaxSalaryWorker(){
        String querySelect = insertDB("sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> result = Database.getInstance().executeQueryForMaxSalaryWorker(querySelect);

        for (MaxSalaryWorker pp : result) {
            maxSalary.add(pp);
        }
        return maxSalary;
    }

    public static List<YoungestEldestWorkers> findYougestEldestWorkers(){
        String querySelect = insertDB("sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorkers> result = Database.getInstance().executeQueryForYoungestEldestWorkers(querySelect);
        for (YoungestEldestWorkers y : result) {
            youngestEldestWorkers.add(y);
        }
        return youngestEldestWorkers;
    }
    public static List<LongestProject> findLongestProject(){
        String querySelect = insertDB("sql/find_longest_project.sql");
        List<LongestProject> result = Database.getInstance().executeQueryForLongestProject(querySelect);
        for (LongestProject y : result) {
            longestProgect.add(y);
        }
        return longestProgect;
    }
}
