package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.service.CourseService;
import az.bdc.courserepoter.service.databaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl extends databaseConnection implements CourseService {

    @Override
    public List<Course> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Course.SELECT_ALL);
            preparedStatement.execute();
            List<Course> courseList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getLong("id"));
                course.setAddress(resultSet.getString("address"));
                course.setName(resultSet.getString("name"));
                course.setPhoneNumber(resultSet.getString("phone_number"));
                course.setCreateDate(resultSet.getObject("create_date", LocalDateTime.class));
                course.setUpdateDate(resultSet.getObject("update_date", LocalDateTime.class));
                courseList.add(course);
            }
            return courseList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean add(Course course) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Course.INSERT_INTO);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getAddress());
            preparedStatement.setString(3, course.getPhoneNumber());
            preparedStatement.setObject(4, course.getCreateDate());
            preparedStatement.setObject(5, course.getUpdateDate());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(Course course) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Course.UPDATE_SET);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setString(2, course.getAddress());
            preparedStatement.setString(3, course.getPhoneNumber());
            preparedStatement.setObject(4, course.getUpdateDate());
            preparedStatement.setLong(5, course.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Course.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
