package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.CourseStudentContract;
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
            List<CourseStudentContract> contractList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                CourseStudentContract c = new CourseStudentContract();
                c.setId(resultSet.getLong("id"));
                c.setContractDate(resultSet.getTimestamp("contract_date"));
                c.setMonthlyAmount(resultSet.getBigDecimal("monthly_amount"));
                c.setTotalAmount(resultSet.getBigDecimal("total_amount"));
                c.setCourseID(resultSet.getLong("course_id"));
                c.setStudentID(resultSet.getLong("student_id"));
                c.setCreateDate(resultSet.getObject("create_date", LocalDateTime.class));
                c.setUpdateDate(resultSet.getObject("update_date", LocalDateTime.class));
                contractList.add(c);
            }
            return contractList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean add(CourseStudentContract c) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseStudentContract.INSERT_INTO);
            preparedStatement.setTimestamp(1, c.getContractDate());
            preparedStatement.setBigDecimal(2, c.getTotalAmount());
            preparedStatement.setBigDecimal(3, c.getMonthlyAmount());
            preparedStatement.setLong(4, c.getCourseID());
            preparedStatement.setLong(5, c.getStudentID());
            preparedStatement.setObject(6, c.getCreateDate());
            preparedStatement.setObject(7, c.getUpdateDate());

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(CourseStudentContract c) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseStudentContract.UPDATE_SET);
            preparedStatement.setTimestamp(1, c.getContractDate());
            preparedStatement.setBigDecimal(2, c.getTotalAmount());
            preparedStatement.setBigDecimal(3, c.getMonthlyAmount());
            preparedStatement.setLong(4, c.getCourseID());
            preparedStatement.setLong(5, c.getStudentID());
            preparedStatement.setObject(6, c.getUpdateDate());
            preparedStatement.setLong(7, c.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseStudentContract.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
