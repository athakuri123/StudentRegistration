package com.experimental.StudentRegistration.Service;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class StudentEntryService
{

    //DB Credentialss
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Registration?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "m@nepAli2";

    public static void main(String[] args) throws SQLException, IOException {
        Logger logger = Logger.getLogger(StudentEntryService.class.getName());
        FileHandler fh;
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter 1 to continue or 2 to end:");
        String userIn = scanner.nextLine();
        if (userIn.equals("1")) {
                //Get entry data from user
                System.out.println("Enter First Name:");
                String fName = scanner.nextLine();  // Read user input
                System.out.println("Enter Last Name:");
                String lName = scanner.nextLine();  // Read user input
                System.out.println("Enter Major:");
                String major = scanner.nextLine();  // Read user input


                //Database entry to use in data entry service
                String entry = "INSERT INTO Registration.Students (fst_name, lst_name, major) VALUES('" + fName + "', '" + lName + "', '" + major + "');";

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

        logger.info("Program ended...");

    }

}
