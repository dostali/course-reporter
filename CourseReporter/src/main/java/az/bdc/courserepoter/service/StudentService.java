package az.bdc.courserepoter.service;

import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    boolean add(Student student);

    boolean update(Student student);

    boolean deleteById(long id);


}
