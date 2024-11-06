package com.napier.sem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class App {

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;
    public static void main(String[] args) throws IOException {
        // Create new Application
        App a = new App();

        if (args.length < 1) {
            //local
            a.connect("localhost:33060", 10000);
        } else {
            //docker parameters passed from Dockerfile
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        a.report2();

        City city = a.getCity(1);
        a.displayCity(city);
        // Disconnect from database
        a.disconnect();
    }

    public void report2() throws IOException {
        StringBuilder sb = new StringBuilder();
//        try {
//            // Create an SQL statement
//            Statement stmt = con.createStatement();
//            // Create string for SQL statement
//            String sql = "select * from country";
//            // Execute SQL statement
//            ResultSet rset = stmt.executeQuery(sql);
//            //cycle
//            while (rset.next()) {
//                String name = rset.getString("name");
//                Integer population = rset.getInt("population");
//                sb.append(name + "\t" + population + "\r\n");
//            }
//            new File("./output/").mkdir();
//            BufferedWriter writer = new BufferedWriter(
//                    new FileWriter(new File("./output/report1.txt")));
//            writer.write(sb.toString());
//            writer.close();
//            System.out.println(sb.toString());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println("Failed to get details");
//            return;
//        }
//
//        System.out.println(sb.toString());
    }

    //Display City
    public void displayCity(City city) throws IOException
    {
        if (city != null)
        {
            System.out.println(
                    "ID: " + city.ID + "\n"
                            + "City:" + city.Name + "\n"
                            + "Code:" + city.CountryCode + "\n"
                            + "District:" + city.District + "\n"
                            + "Population:" + city.Population + "\n");
        }
    }

    //    To get city info
    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population "
                            + "FROM city "
                            + "WHERE ID = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Check if a result is returned
            if (rset.next())
            {
                City city = new City();
                city.ID = rset.getInt("ID");
                city.Name = rset.getString("Name");
                city.CountryCode = rset.getString("CountryCode");
                city.District = rset.getString("District");
                city.Population = rset.getInt("Population");
                return city;
            }
            else {
                return null;
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }




    /**
     * Connect to the MySQL database.
     *
     * @param conString
     * 		Use db:3306 for docker and localhost:33060 for local or Integration
     * 		Tests
     * @param
     */
    public void connect(String conString, int delay) {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                if (shouldWait) {
                    Thread.sleep(delay);
                }
                // Connect to database
                //Added allowPublicKeyRetrieval=true to get Integration Tests
                // to work. Possibly due to accessing from another class?
                con = DriverManager.getConnection("jdbc:mysql://" + conString
                        + "/world?allowPublicKeyRetrieval=true&useSSL"
                        + "=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt "
                        + Integer.toString(i));
                System.out.println(sqle.getMessage());
                shouldWait = true;
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }
    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }
}