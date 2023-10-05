package az.bdc.courserepoter.domain;

import java.time.LocalDateTime;

public class CourseTeacherContract {
    private long id;
    long course_id;
    long teacher_id;
    double monthly_ammount;
    double total_ammount;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public CourseTeacherContract(long id, long course_id, long teacher_id, double monthly_ammount, double total_ammount, LocalDateTime createDate, LocalDateTime updateDate) {
        this.id = id;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.monthly_ammount = monthly_ammount;
        this.total_ammount = total_ammount;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
    public CourseTeacherContract(){}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public double getMonthly_ammount() {
        return monthly_ammount;
    }

    public void setMonthly_ammount(double monthly_ammount) {
        this.monthly_ammount = monthly_ammount;
    }

    public double getTotal_ammount() {
        return total_ammount;
    }

    public void setTotal_ammount(double total_ammount) {
        this.total_ammount = total_ammount;
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



