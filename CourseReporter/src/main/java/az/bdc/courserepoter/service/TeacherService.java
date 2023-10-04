package az.bdc.courserepoter.service;

import az.bdc.courserepoter.domain.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAll();

    boolean add(Teacher teacher);

    boolean update(Teacher teacher);

    boolean deleteById(long id);

}
