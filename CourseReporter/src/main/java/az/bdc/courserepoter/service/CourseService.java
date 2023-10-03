package az.bdc.courserepoter.service;

import az.bdc.courserepoter.domain.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAll();

    boolean add(Course course);

    boolean update(Course course);

    boolean deleteById(long id);


}
