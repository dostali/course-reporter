package az.bdc.courserepoter.domain;

import java.time.LocalDateTime;

public class StudentMonthlyPayment {
    private  long id;
    private double amount;
    private String month;
    private  long contract_id;
    private LocalDateTime create_date;
    private LocalDateTime update_date;


    public StudentMonthlyPayment() {
    }

    public StudentMonthlyPayment(long id, double amount, String month, long contract_id, LocalDateTime create_date, LocalDateTime update_date) {
        this.id = id;
        this.amount = amount;
        this.month = month;
        this.contract_id = contract_id;
        this.create_date = create_date;
        this.update_date = update_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getContract_id() {
        return contract_id;
    }

    public void setContract_id(long contract_id) {
        this.contract_id = contract_id;
    }

    public LocalDateTime getCreate_date() {
        return create_date;
    }

    public void setCreate_date(LocalDateTime create_date) {
        this.create_date = create_date;
    }

    public LocalDateTime getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(LocalDateTime update_date) {
        this.update_date = update_date;
    }

    @Override
    public String toString() {
        return "StudentMonthlyPayment{" +
                "id=" + id +
                ", amount=" + amount +
                ", month='" + month + '\'' +
                ", contract_id=" + contract_id +
                ", create_date=" + create_date +
                ", update_date=" + update_date +
                '}';
    }
}

