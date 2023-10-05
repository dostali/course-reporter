package az.bdc.courserepoter.constant;

public final class SqlCommands {


    public static class Course {
        public final static String SELECT_ALL = "select * from course c";
        public final static String INSERT_INTO = "insert into course(name, address, phone_number, create_date, update_date) values(?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from course where id=?";

        public final static String UPDATE_SET = "update course set name=?, address=?, phone_number=?, update_date=? where id = ?";
    }

    public static class Teacher {
        public final static String SELECT_ALL = "select * from teacher ";
        public final static String INSERT_INTO = "insert into teacher (name,surname,phone_number,create_date,update_date) values (?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from teacher where id=?";
        public final static String UPDATE_SET = "update teacher (name=?,surname=?,phone_number=?,update_date=?) where id=?)";
    }

    public static class CourseTeacherContract {
        public final static String SELECT_ALL = "select * from course_teacher_contract ";
        public final static String INSERT_INTO = "insert into course_teacher_contract (total_amount,monthly_amount,course_id,teacher_id,create_date,update_date) values(?,?,?,?,?,?) ";
        public final static String DELETE_BY_ID = "delete from course_teacher_contract where id=?";
        public final static String UPDATE_SET = "update course_teacher_contract (total_amount=?,monthly_amount=?,course_id=?,teacher_id=?,create_date=?,update_date=?) where id=?)";
    }

    public static class TeacherMonthlySalary {
        public final static String SELECT_ALL = "select * from teacher_monthly_payment ";
        public final static String INSERT_INTO = "insert into teacher_monthly_payment (amount,create_date,update_date,month,contract_id) values(?,?,?,?,?) ";
        public final static String DELETE_BY_ID = "delete from teacher_monthly_payment where id=?";
        public final static String UPDATE_SET = "update teacher_monthly_payment (amount=?,update_date=?,month=?,contract_id=?) where id=?)";

        static class Students {

        }
    }
}
