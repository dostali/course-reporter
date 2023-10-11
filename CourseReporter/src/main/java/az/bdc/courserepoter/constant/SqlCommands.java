package az.bdc.courserepoter.constant;

public final class SqlCommands {



    public static class Course{
        public final static String SELECT_ALL = "select * from course";
        public final static String INSERT_INTO = "insert into course(name, address, phone_number, create_date, update_date) values(?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from course where id=?";
        public final static String UPDATE_SET = "update course set name=?, address=?, phone_number=?, update_date=? where id = ?";
    }

    static class Students{

    }
    public static class StudentMonthlyPayment{
        public final static String SELECT_ALL = "select * from student_monthly_payment";
        public final static String INSERT_INTO = "insert into student_monthly_payment(amount, month, contract_id, create_date, update_date) values(?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from student_monthly_payment where id=?";
        public final static String UPDATE_SET = "update student_monthly_payment set amount=?, month=?, contract_id=?, update_date=? where id = ?";
    }

    public static class CourseDetails{
            public final static String SELECT_ALL = "select * from course_details";
        public final static String INSERT_INTO = "insert into course_details(name, adress, phone_number, course_id) values(?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from course_details where id=?";
        public final static String UPDATE_SET = "update course_details set name=?, adress=?,phone_name=?, course_id=? where id = ?";
    }

    public static class TeacherSubjects{
        public final static String SELECT_ALL = "select * from teacher_subjects";
        public final static String INSERT_INTO = "insert into teacher_subjects(teacher_id,subject_id,fullname) values(?,?,?)";
        public final static String DELETE_BY_ID = "delete from teacher_subjects where id=?";
        public final static String UPDATE_SET = "update teacher_subjects set teacher_id=?, subject_id=?, fullname=? where id = ?";
    }


}
