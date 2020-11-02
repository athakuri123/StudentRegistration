package com.experimental.StudentRegistration.Service;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DbService
{

    //DB Credentialss
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/Registration?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "m@nepAli2";

    public static void main(String[] args) throws SQLException, IOException
    {
        Logger logger = Logger.getLogger(DbService.class.getName());
        FileHandler fh;

        String info = "SELECT * FROM Registration.Students;";
        try {
            fh = new FileHandler("src/main/resources/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            logger.info("Connecting to database...");
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement state = con.createStatement();

            logger.info("Printing database info...");

            ResultSet rs = state.executeQuery(info);
            while (rs.next())
            {
                //Prints all records
                String studentID = rs.getString("student_id");
                String firstName = rs.getString("fst_name");
                String lastName = rs.getString("lst_name");
                System.out.format("| %s | %s | %s |\n" , studentID, firstName, lastName);
            }
            state.close();

            logger.info("Done...");


        }catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (SQLException se) {
            se.printStackTrace();
        }

    }

}
