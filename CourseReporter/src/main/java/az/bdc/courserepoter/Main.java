package az.bdc.courserepoter;

import az.bdc.courserepoter.constant.SqlCommands;
import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.Teacher;
import az.bdc.courserepoter.service.CourseService;
import az.bdc.courserepoter.service.TeacherService;
import az.bdc.courserepoter.service.impl.CourseServiceImpl;
import az.bdc.courserepoter.service.impl.TeacherServiceImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        CourseService courseService = new CourseServiceImpl();
//        Course course = new Course();
//        course.setId(1);
//        course.setName("Dostali");
//        course.setAddress("Saatli");
//        course.setPhoneNumber("514910744");
//        course.setUpdateDate(LocalDateTime.now());
//        course.setCreateDate(LocalDateTime.now());
//
//        courseService.add(course);
//        courseService.getAll().forEach(System.out::println);

        TeacherService teacherService = new TeacherServiceImpl();
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("Mikayil");
        teacher.setSurname("Nurmemmedov");
        teacher.setPhoneNumber("+994701234567");
        teacher.setCreateDate(LocalDateTime.now());
        teacher.setUpdateDate(LocalDateTime.now());
        teacherService.add(teacher);
        teacherService.getAll().forEach(System.out::println);

    }
}