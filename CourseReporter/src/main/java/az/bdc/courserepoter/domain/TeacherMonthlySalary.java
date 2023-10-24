package az.bdc.courserepoter.domain;
import java.time.LocalDateTime;

public class TeacherMonthlySalary {
    private long id;
    long contract_id;
    double amount;
    String month;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public TeacherMonthlySalary(long id, long contract_id, double amount, String month, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.contract_id = contract_id;
        this.amount = amount;
        this.month = month;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public TeacherMonthlySalary(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContract_id() {
        return contract_id;
    }

    public void setContract_id(long contract_id) {
        this.contract_id = contract_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    @Override
    public String toString() {
        return "TeacherMonthlySalary{" +
                "id=" + id +
                ", contract_id=" + contract_id +
                ", amount=" + amount +
                ", month='" + month + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
