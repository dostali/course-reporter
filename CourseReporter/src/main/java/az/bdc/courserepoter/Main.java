package az.bdc.courserepoter;

import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.CourseStudentContract;
import az.bdc.courserepoter.service.CourseService;
import az.bdc.courserepoter.service.CourseStudentContractService;
import az.bdc.courserepoter.service.impl.CourseServiceImpl;
import az.bdc.courserepoter.service.impl.CourseStudentContractServiceImpl;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();
        Course course = new Course();
        course.setId(1);
        course.setName("Dostali");
        course.setAddress("Saatli");
        course.setPhoneNumber("514910744");
        course.setUpdateDate(LocalDateTime.now());
        course.setCreateDate(LocalDateTime.now());

        courseService.add(course);
        courseService.getAll().forEach(System.out::println);

    }
}