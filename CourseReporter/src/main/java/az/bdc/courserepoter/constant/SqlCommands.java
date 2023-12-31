package az.bdc.courserepoter.constant;

public final class SqlCommands {


    public static class Course {
        public final static String SELECT_ALL = "select * from course c";
        public final static String INSERT_INTO = "insert into course(name, address, phone_number, create_date, update_date) values(?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from course where id=?";

        public final static String UPDATE_SET = "update course set name=?, address=?, phone_number=?, update_date=? where id = ?";
    }

    public static class Student {
        public final static String SELECT_ALL = "select * from student";
        public final static String INSERT_INTO = "insert into student(name, surname, fullname, birthdate, phone_number, pincode, create_date, update_date) values(?,?,?,?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from student where id=?";
        public final static String UPDATE_SET = "update student set name=?, surname=?, fullname=?, birthdate=?, phone_number=?, pincode=?, update_date=? where id = ?";

    }

    public static class Teacher {
        public final static String SELECT_ALL = "select * from teacher ";
        public final static String INSERT_INTO = "insert into teacher (name,surname,phone_number,create_date,update_date) values (?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from teacher where id=?";
        public final static String UPDATE_SET = "update teacher name=?,surname=?,phone_number=?,update_date=? where id=?)";
    }
}

