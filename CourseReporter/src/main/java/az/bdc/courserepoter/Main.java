package az.bdc.courserepoter;

import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.Student;
import az.bdc.courserepoter.service.CourseService;
import az.bdc.courserepoter.service.StudentService;
import az.bdc.courserepoter.service.impl.CourseServiceImpl;
import az.bdc.courserepoter.service.impl.StudentServiceImpl;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

//        courseService.add(course);
//        courseService.getAll().forEach(System.out::println);

        StudentService studentService = new StudentServiceImpl();
        Student student = new Student();
        student.setId(1);
        student.setName("Tural");
        student.setSurname("Museyibov");
        student.setFullName();
        student.setPhoneNumber("+994 51 660 22 92");
        student.setPinCode("1234");

        String pattern = "dd/mm/yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);

        // set birthdate
        try {
            Date date = format.parse("25/02/1992");
            System.out.println(date);
            student.setBirthDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        student.setCreateDate(LocalDateTime.now());
        student.setUpdateDate(LocalDateTime.now());

        studentService.add(student);
        studentService.getAll().forEach(System.out::println);

    }
}