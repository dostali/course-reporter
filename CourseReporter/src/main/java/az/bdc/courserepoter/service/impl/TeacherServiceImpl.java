package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.Teacher;
import az.bdc.courserepoter.service.DatabaseConncetion;
import az.bdc.courserepoter.service.TeacherService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeacherServiceImpl extends DatabaseConncetion implements TeacherService {


    @Override
    public List<Teacher> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Teacher.SELECT_ALL);
            preparedStatement.execute();
            List<Teacher> TeacherList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getLong("id"));
                teacher.setName(resultSet.getString("name"));
                teacher.setSurname(resultSet.getString("surname"));
                teacher.setPhoneNumber(resultSet.getString("phone_number"));
                teacher.setCreateDate(resultSet.getObject("create_date", LocalDateTime.class));
                teacher.setUpdateDate(resultSet.getObject("update_date", LocalDateTime.class));
                TeacherList.add(teacher);
            }
            return TeacherList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public boolean add (Teacher teacher) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Teacher.INSERT_INTO);
            preparedStatement.setString(1, teacher.getName());
            preparedStatement.setString(2, teacher.getSurname());
            preparedStatement.setString(3, teacher.getPhoneNumber());
            preparedStatement.setObject(4, teacher.getCreateDate());
            preparedStatement.setObject(5, teacher.getUpdateDate());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
        @Override
        public boolean update (Teacher teacher){
            try (Connection connection = connect()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Teacher.UPDATE_SET);
                preparedStatement.setString(1, teacher.getName());
                preparedStatement.setString(2, teacher.getSurname());
                preparedStatement.setString(3, teacher.getPhoneNumber());
                preparedStatement.setObject(4, teacher.getUpdateDate());
                preparedStatement.setLong(5, teacher.getId());
                return preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
            @Override
            public boolean deleteById ( long id){
                try (Connection connection = connect()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.Teacher.DELETE_BY_ID);
                    preparedStatement.setLong(1, id);
                    return preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }

}
