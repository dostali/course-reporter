package az.bdc.courserepoter;

import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.StudentMonthlyPayment;
import az.bdc.courserepoter.service.CourseService;
import az.bdc.courserepoter.service.impl.CourseServiceImpl;
import az.bdc.courserepoter.service.impl.StudentMonthlyPaymentService;
import az.bdc.courserepoter.service.impl.StudentMonthlyPaymentServiceImpl;

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



        StudentMonthlyPaymentService studentMonthlyPaymentService = new StudentMonthlyPaymentServiceImpl();
        StudentMonthlyPayment studentMonthlyPayment = new StudentMonthlyPayment();
        studentMonthlyPayment.setId(1);
        studentMonthlyPayment.setAmount(350);
        studentMonthlyPayment.setMonth("Yanvar");
        studentMonthlyPayment.setContract_id(20232023);
        studentMonthlyPayment.setUpdate_date(LocalDateTime.now());
        studentMonthlyPayment.setCreate_date(LocalDateTime.now());

        studentMonthlyPaymentService.add(studentMonthlyPayment);
        studentMonthlyPaymentService.getAll().forEach(System.out::println);

    }
}