package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.TeacherSubjects;
import az.bdc.courserepoter.service.DatabaseConncetion;
import az.bdc.courserepoter.service.TeacherSubjectsService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherSubjectsServiceImpl extends DatabaseConncetion implements TeacherSubjectsService {
    @Override
    public List<TeacherSubjects> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherSubjects.SELECT_ALL);
            preparedStatement.execute();
            List<TeacherSubjects> teacherSubjectsList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                TeacherSubjects teacherSubjects = new TeacherSubjects();
                teacherSubjects.setId(resultSet.getLong("id"));
                teacherSubjects.setTeacherID(resultSet.getLong("teacher_id"));
                teacherSubjects.setSubjectsID(resultSet.getLong("subject_id"));
                teacherSubjects.setFullname(resultSet.getString("fullname"));
                teacherSubjectsList.add(teacherSubjects);
            }
            return teacherSubjectsList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean add(TeacherSubjects teacherSubjects) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherSubjects   .UPDATE_SET);
            preparedStatement.setLong(1, teacherSubjects.getTeacherID());
            preparedStatement.setLong(2, teacherSubjects.getSubjectsID());
            preparedStatement.setString(3, teacherSubjects.getFullname());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean update(TeacherSubjects teacherSubjects) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherSubjects.INSERT_INTO);
            preparedStatement.setLong(1, teacherSubjects.getTeacherID());
            preparedStatement.setLong(2, teacherSubjects.getSubjectsID());
            preparedStatement.setString(3, teacherSubjects.getFullname());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean deleteById(long id) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.TeacherSubjects.DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
