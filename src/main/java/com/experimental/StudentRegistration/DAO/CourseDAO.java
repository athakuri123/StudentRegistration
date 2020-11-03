package com.experimental.StudentRegistration.DAO;
import java.util.List;
import com.experimental.StudentRegistration.Model.Courses;

public interface CourseDAO
{
    public void saveOrUpdate(Courses courses);

    public void delete(int contactId);

    public Courses get(int contactId);

    public List<Courses> list();
}
