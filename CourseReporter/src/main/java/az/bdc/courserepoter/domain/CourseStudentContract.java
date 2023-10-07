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
    public CourseStudentContract(){

    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getContractDate() {
        return contractDate;
    }

    public void setContractDate(Timestamp contractDate) {
        this.contractDate = contractDate;
    }

    public BigDecimal getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(BigDecimal monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }

    public long getStudentID() {
        return studentID;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
