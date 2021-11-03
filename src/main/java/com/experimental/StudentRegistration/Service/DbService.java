package com.experimental.StudentRegistration.Service;
import java.io.*;
import java.sql.*;
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
        String courseInfo = "SELECT * FROM Registration.Classes";
        //Database entry to use in data entry service
        //String entry = "INSERT INTO Registration.Students (student_id, fst_name, lst_name, major) VALUES('3', 'James', 'Harrison', 'Accounting');";
        try {
            fh = new FileHandler("src/main/resources/DataView.log");
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
                String major = rs.getString("major");
                System.out.format("| %s | %s | %s | %s |\n" , studentID, firstName, lastName, major);
            }

            System.out.println();

            ResultSet cr = state.executeQuery(courseInfo);
            while (cr.next())
            {
                String courseId = cr.getString("course_id");
                String courseName = cr.getString("course_name");
                String cMajor = cr.getString("major");

                System.out.format("| %s | %s | %s |\n" , courseId, courseName, cMajor);
            }
            //Use below for database entry
            //state.execute(entry);
            //logger.info("Data entered...");

            state.close();

            logger.info("Done...");


        }catch (IOException ioe) {
            ioe.printStackTrace();
        }catch (SQLException se) {
            se.printStackTrace();
        }

    }

}
