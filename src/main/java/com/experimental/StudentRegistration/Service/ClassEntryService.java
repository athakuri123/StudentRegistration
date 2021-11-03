package com.experimental.StudentRegistration.Service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ClassEntryService {

    //DB Credentialss
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Registration?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "m@nepAli2";

    public static void main(String[] args) throws SQLException, IOException {
        //Get entry data from user
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Course ID:");
        String id = scanner.nextLine();  // Read user input
        System.out.println("Enter Course Name:");
        String name = scanner.nextLine();  // Read user input
        System.out.println("Enter Major:");
        String major = scanner.nextLine();  // Read user input

        Logger logger = Logger.getLogger(ClassEntryService.class.getName());
        FileHandler fh;

        //Database entry to use in data entry service
        String entry = "INSERT INTO Registration.Classes (couse_id, course_name, major) VALUES('" + id + "', '" + name + "', '" + major + "');";

        try {
            fh = new FileHandler("src/main/resources/EntryLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Connecting to database...");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement state = con.createStatement();

            state.execute(entry);
            logger.info("Data entered...");

            state.close();

            logger.info("Done...");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
