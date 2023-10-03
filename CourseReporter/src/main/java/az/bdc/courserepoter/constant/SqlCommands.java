package az.bdc.courserepoter.constant;

public final class SqlCommands {



    public static class Course{
        public final static String SELECT_ALL = "select * from course c";
        public final static String INSERT_INTO = "insert into course(name, address, phone_number, create_date, update_date) values(?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from course where id=?";

        public final static String UPDATE_SET = "update course set name=?, address=?, phone_number=?, update_date=? where id = ?";
    }

    static class Students{

    }


}
