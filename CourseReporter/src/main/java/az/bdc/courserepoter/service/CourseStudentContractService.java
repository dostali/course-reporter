package az.bdc.courserepoter.service;
import az.bdc.courserepoter.domain.CourseStudentContract;

import java.util.List;

public interface CourseStudentContractService {

    List<CourseStudentContract> getAll();

    boolean add(CourseStudentContract c);

    boolean update(CourseStudentContract c);

    boolean deleteById(long id);

}
