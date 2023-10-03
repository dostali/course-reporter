package az.bdc.courserepoter.service.impl;

import az.bdc.courserepoter.domain.Course;
import az.bdc.courserepoter.domain.StudentMonthlyPayment;

import java.util.List;

public interface StudentMonthlyPaymentService {

    List<StudentMonthlyPayment> getAll();

    boolean add(StudentMonthlyPayment studentMonthlyPayment);

    boolean update(StudentMonthlyPayment studentMonthlyPayment);

    boolean deleteById(long id);
}
