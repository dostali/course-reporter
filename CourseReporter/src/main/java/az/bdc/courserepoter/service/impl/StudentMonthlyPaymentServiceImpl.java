package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.StudentMonthlyPayment;
import az.bdc.courserepoter.service.DatabaseConncetion;
import az.bdc.courserepoter.service.StudentMonthlyPaymentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StudentMonthlyPaymentServiceImpl extends DatabaseConncetion implements StudentMonthlyPaymentService {

    @Override
    public List<StudentMonthlyPayment> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.StudentMonthlyPayment.SELECT_ALL);
            preparedStatement.execute();
            List<StudentMonthlyPayment> studentMonthlyPaymentslist = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                StudentMonthlyPayment studentMonthlyPayment = new StudentMonthlyPayment();
                studentMonthlyPayment.setId(resultSet.getLong("id"));
                studentMonthlyPayment.setAmount(resultSet.getDouble("amount"));
                studentMonthlyPayment.setMonth(resultSet.getString("month"));
                studentMonthlyPayment.setContract_id(resultSet.getLong("contract_id"));
                studentMonthlyPayment.setCreate_date(resultSet.getObject("create_date", LocalDateTime.class));
                studentMonthlyPayment.setUpdate_date(resultSet.getObject("update_date", LocalDateTime.class));
                studentMonthlyPaymentslist.add(studentMonthlyPayment);
            }
            return studentMonthlyPaymentslist;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean add(StudentMonthlyPayment studentMonthlyPayment) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.StudentMonthlyPayment.INSERT_INTO);
            preparedStatement.setDouble(1, studentMonthlyPayment.getAmount());
            preparedStatement.setString(2, studentMonthlyPayment.getMonth());
            preparedStatement.setLong(3, studentMonthlyPayment.getContract_id());
            preparedStatement.setObject(4, studentMonthlyPayment.getCreate_date());
            preparedStatement.setObject(5, studentMonthlyPayment.getUpdate_date());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(StudentMonthlyPayment studentMonthlyPayment) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.StudentMonthlyPayment.UPDATE_SET);
            preparedStatement.setDouble(1, studentMonthlyPayment.getAmount());
            preparedStatement.setString(2, studentMonthlyPayment.getMonth());
            preparedStatement.setLong(3, studentMonthlyPayment.getContract_id());
            preparedStatement.setObject(4, studentMonthlyPayment.getUpdate_date());
            preparedStatement.setLong(5, studentMonthlyPayment.getId());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.StudentMonthlyPayment.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
