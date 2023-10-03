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
    public static class StudentMonthlyPayment{
        public final static String SELECT_ALL = "select * from studentMonthlyPayment c";
        public final static String INSERT_INTO = "insert into studentMonthlyPayment(amount, month, contract_id, create_date, update_date) values(?,?,?,?,?)";
        public final static String DELETE_BY_ID = "delete from studentMonthlyPayment where id=?";
        public final static String UPDATE_SET = "update studentMonthlyPayment set amount=?, month=?, contract_id=?, update_date=? where id = ?";
    }


}
