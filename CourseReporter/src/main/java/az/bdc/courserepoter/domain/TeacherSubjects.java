package az.bdc.courserepoter.domain;

public class TeacherSubjects {
    private long id;
    private long teacherID;
    private long subjectsID;
    private String fullname;

    public TeacherSubjects() {
    }

    public TeacherSubjects(long id, long teacherID, long subjectsID, String fullname) {
        this.id = id;
        this.teacherID = teacherID;
        this.subjectsID = subjectsID;
        this.fullname = fullname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(long teacherID) {
        this.teacherID = teacherID;
    }

    public long getSubjectsID() {
        return subjectsID;
    }

    public void setSubjectsID(long subjectsID) {
        this.subjectsID = subjectsID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String toString() {
        return "TeacherSubjects{" +
                "id=" + id +
                ", teacherID=" + teacherID +
                ", subjectsID=" + subjectsID +
                ", fullname='" + fullname + '\'' +
                '}';
    }
}
