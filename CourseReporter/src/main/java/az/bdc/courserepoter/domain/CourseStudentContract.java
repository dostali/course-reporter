package az.bdc.courserepoter.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CourseStudentContract {
    private long id;
    private Timestamp contractDate;
    private BigDecimal monthlyAmount;
    private BigDecimal totalAmount;
    private long courseID;
    private long studentID;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public CourseStudentContract(
            long id,
            Timestamp contractDate,
            BigDecimal monthlyAmount,
            BigDecimal totalAmount,
            long courseID,
            long studentID,
            LocalDateTime createDate,
            LocalDateTime updateDate)
    {
        this.id = id;
        this.contractDate = contractDate;
        this.monthlyAmount = monthlyAmount;
        this.totalAmount = totalAmount;
        this.courseID = courseID;
        this.studentID = studentID;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
