package az.bdc.courserepoter.service;

import az.bdc.courserepoter.domain.CourseTeacherContract;

import java.util.List;

public interface CourseTeacherContractService {

    List<CourseTeacherContract> getAll();

    boolean add(CourseTeacherContract courseTeacherContract);

    boolean update(CourseTeacherContract courseTeacherContract);

    boolean deleteById(long id);

}
