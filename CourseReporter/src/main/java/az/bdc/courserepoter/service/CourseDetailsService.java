package az.bdc.courserepoter.service;

import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.CourseDetails;

import java.util.List;

public interface CourseDetailsService {
    List<CourseDetails> getAll();

    boolean add(CourseDetails courseDetails);

    boolean update(CourseDetails courseDetails);

    boolean deleteById(long id);
}
