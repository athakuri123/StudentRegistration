package com.experimental.StudentRegistration.DAO;

import com.experimental.StudentRegistration.Model.Courses;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class CourseDAOImpl implements CourseDAO
{
    private JdbcTemplate jdbcTemplate;

    public CourseDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Courses courses) {

    }

    @Override
    public void delete(int contactId) {

    }

    @Override
    public Courses get(int contactId) {
        return null;
    }

    @Override
    public List<Courses> list() {
        return null;
    }
}
