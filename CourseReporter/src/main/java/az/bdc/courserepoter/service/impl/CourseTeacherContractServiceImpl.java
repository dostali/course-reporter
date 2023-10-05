package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.CourseTeacherContract;
import az.bdc.courserepoter.service.CourseTeacherContractService;
import az.bdc.courserepoter.service.DatabaseConncetion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CourseTeacherContractServiceImpl extends DatabaseConncetion implements CourseTeacherContractService {


    @Override
    public List<CourseTeacherContract> getAll() {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseTeacherContract.SELECT_ALL);
            preparedStatement.execute();
            List<CourseTeacherContract> CourseTeacherContractList = new ArrayList<>();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                CourseTeacherContract courseTeacherContract = new CourseTeacherContract();
                courseTeacherContract.setId(resultSet.getLong("id"));
                courseTeacherContract.setTotal_ammount(resultSet.getDouble("total_amount"));
                courseTeacherContract.setMonthly_ammount(resultSet.getDouble("monthly_amount"));
                courseTeacherContract.setId(resultSet.getLong("course_id"));
                courseTeacherContract.setId(resultSet.getLong("teacher_id"));
                courseTeacherContract.setCreateDate(resultSet.getObject("create_date", LocalDateTime.class));
                courseTeacherContract.setUpdateDate(resultSet.getObject("update_date",LocalDateTime.class));
                CourseTeacherContractList.add(courseTeacherContract);
            }
            return CourseTeacherContractList;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public boolean add (CourseTeacherContract courseTeacherContract) {
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseTeacherContract.INSERT_INTO);
            preparedStatement.setDouble(1, courseTeacherContract.getTotal_ammount());
            preparedStatement.setDouble(2, courseTeacherContract.getMonthly_ammount());
            preparedStatement.setLong(3, courseTeacherContract.getCourse_id());
            preparedStatement.setLong(4, courseTeacherContract.getTeacher_id());
            preparedStatement.setObject(5, courseTeacherContract.getCreateDate());
            preparedStatement.setObject(6,courseTeacherContract.getUpdateDate());
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
        @Override
        public boolean update (CourseTeacherContract courseTeacherContract){
            try (Connection connection = connect()) {
                PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseTeacherContract.UPDATE_SET);
                preparedStatement.setDouble(1, courseTeacherContract.getTotal_ammount());
                preparedStatement.setDouble(2, courseTeacherContract.getMonthly_ammount());
                preparedStatement.setLong(3, courseTeacherContract.getCourse_id());
                preparedStatement.setLong(4, courseTeacherContract.getTeacher_id());
                preparedStatement.setObject(5,courseTeacherContract.getCreateDate());
                preparedStatement.setObject(6,courseTeacherContract.getUpdateDate());
                return preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
            @Override
            public boolean deleteById ( long id){
                try (Connection connection = connect()) {
                    PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.CourseTeacherContract.DELETE_BY_ID);
                    preparedStatement.setLong(1, id);
                    return preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }

}
