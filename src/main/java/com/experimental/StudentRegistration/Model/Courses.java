package com.experimental.StudentRegistration.Model;

public class Courses
{
    private String courseName;
    private String courseID;
    private String major;

    public Courses() {
    }

    public Courses(String courseName, String courseID, String major) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.major = major;
    }

    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseID() { return courseID; }

    public void setCourseID(String courseID) { this.courseID = courseID; }

    public String getMajor() { return major; }

    public void setMajor(String major) { this.major = major; }
}
