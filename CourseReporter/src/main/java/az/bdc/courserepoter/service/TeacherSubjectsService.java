package az.bdc.courserepoter.service;

import az.bdc.courserepoter.domain.CourseDetails;
import az.bdc.courserepoter.domain.TeacherSubjects;

import java.util.List;

public interface TeacherSubjectsService {
    List<TeacherSubjects> getAll();

    boolean add(TeacherSubjects teacherSubjects);

    boolean update(TeacherSubjects teacherSubjects);

    boolean deleteById(long id);
}
