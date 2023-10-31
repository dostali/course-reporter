package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.CourseDetails;
import az.bdc.courserepoter.service.CourseDetailsService;
import az.bdc.courserepoter.service.DatabaseConncetion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDetailsServiceImpl extends DatabaseConncetion implements CourseDetailsService {
    @Override
    public List<CourseDetails> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseDetails.SELECT_ALL);
            preparedStatement.execute();
            List<CourseDetails> courseDetailsList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                CourseDetails courseDetails = new CourseDetails();
                courseDetails.setId(resultSet.getLong("id"));
                courseDetails.setAdress(resultSet.getString("adress"));
                courseDetails.setName(resultSet.getString("name"));
                courseDetails.setPhoneNumber(resultSet.getString("phone_number"));
                courseDetails.setCourseID(resultSet.getLong("course_id"));
                courseDetailsList.add(courseDetails);
            }
            return courseDetailsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean add(CourseDetails courseDetails) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseDetails.UPDATE_SET);
            preparedStatement.setString(1, courseDetails.getName());
            preparedStatement.setString(2, courseDetails.getAdress());
            preparedStatement.setString(3, courseDetails.getPhoneNumber());
            preparedStatement.setLong(4, courseDetails.getCourseID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(CourseDetails courseDetails) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseDetails.INSERT_INTO);
            preparedStatement.setString(1, courseDetails.getName());
            preparedStatement.setString(2, courseDetails.getAdress());
            preparedStatement.setString(3, courseDetails.getPhoneNumber());
            preparedStatement.setLong(4, courseDetails.getCourseID());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseDetails.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
