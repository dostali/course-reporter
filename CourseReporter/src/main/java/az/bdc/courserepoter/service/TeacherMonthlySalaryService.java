package az.bdc.courserepoter.service;


import az.bdc.courserepoter.domain.TeacherMonthlySalary;

import java.util.List;

public interface TeacherMonthlySalaryService {

    List<TeacherMonthlySalary> getAll();

    boolean add(TeacherMonthlySalary teacherMonthlySalary);

    boolean update(TeacherMonthlySalary teacherMonthlySalary);

    boolean deleteById(long id);

}
