package az.bdc.courserepoter.service.impl;
import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.TeacherMonthlySalary;
import az.bdc.courserepoter.service.DatabaseConncetion;
import az.bdc.courserepoter.service.TeacherMonthlySalaryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeacherMonthlySalaryServiceImpl extends DatabaseConncetion implements TeacherMonthlySalaryService {


    @Override
    public List<TeacherMonthlySalary> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherMonthlySalary.SELECT_ALL);
            preparedStatement.execute();
            List<TeacherMonthlySalary> TeacherMonthlySalaryList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                TeacherMonthlySalary teacherMonthlySalary = new TeacherMonthlySalary();
                teacherMonthlySalary.setId(resultSet.getLong("id"));
                teacherMonthlySalary.setAmount(resultSet.getDouble("amount"));
                teacherMonthlySalary.setCreateDate(resultSet.getObject("create_date", LocalDateTime.class));
                teacherMonthlySalary.setUpdateDate(resultSet.getObject("update_date", LocalDateTime.class));
                teacherMonthlySalary.setMonth(resultSet.getString("month"));
                teacherMonthlySalary.setContract_id(resultSet.getLong("contract_id"));
                TeacherMonthlySalaryList.add(teacherMonthlySalary);
            }
            return TeacherMonthlySalaryList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public boolean add (TeacherMonthlySalary teacherMonthlySalary) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherMonthlySalary.INSERT_INTO);
            preparedStatement.setDouble(1, teacherMonthlySalary.getAmount());
            preparedStatement.setObject(2, teacherMonthlySalary.getCreateDate());
            preparedStatement.setObject(3, teacherMonthlySalary.getUpdateDate());
            preparedStatement.setString(4, teacherMonthlySalary.getMonth());
            preparedStatement.setLong(5, teacherMonthlySalary.getContract_id());

            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
        @Override
        public boolean update (TeacherMonthlySalary teacherMonthlySalary){
            try (Connection connection = connect()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherMonthlySalary.UPDATE_SET);
                preparedStatement.setDouble(1, teacherMonthlySalary.getAmount());
                preparedStatement.setObject(2, teacherMonthlySalary.getUpdateDate());
                preparedStatement.setString(3, teacherMonthlySalary.getMonth());
                preparedStatement.setLong(4, teacherMonthlySalary.getContract_id());
                return preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
            @Override
            public boolean deleteById ( long id){
                try (Connection connection = connect()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherMonthlySalary.DELETE_BY_ID);
                    preparedStatement.setLong(1, id);
                    return preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }

}
