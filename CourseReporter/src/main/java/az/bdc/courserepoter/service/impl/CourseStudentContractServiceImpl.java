package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.CourseStudentContract;
import az.bdc.courserepoter.service.CourseService;
import az.bdc.courserepoter.service.CourseStudentContractService;
import az.bdc.courserepoter.service.DatabaseConncetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseStudentContractServiceImpl extends DatabaseConncetion implements CourseStudentContractService {

    @Override
    public List<CourseStudentContract> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseStudentContract.SELECT_ALL);
            preparedStatement.execute();
            List<CourseStudentContract> courseList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                CourseStudentContract c = new CourseStudentContract();
                c.setId(resultSet.getLong("id"));
                c.setAddress(resultSet.getString("address"));
                c.setName(resultSet.getString("name"));
                c.setPhoneNumber(resultSet.getString("phone_number"));
                c.setCreateDate(resultSet.getObject("create_date", LocalDateTime.class));
                c.setUpdateDate(resultSet.getObject("update_date", LocalDateTime.class));
                courseList.add(c);
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
