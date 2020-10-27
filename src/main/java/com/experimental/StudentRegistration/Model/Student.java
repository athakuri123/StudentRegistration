package com.experimental.StudentRegistration.Model;

public class Student
{
    private String firstName;
    private String lastName;
    private String studentID;
    private String major;

    public Student ()
    {}

    public Student (String firstName, String lastName, String studentID, String major)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.major = major;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
