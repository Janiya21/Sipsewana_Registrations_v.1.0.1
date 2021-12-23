package lk.ijse.pos.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student_Program {

    @Id
    private String id;
    private String programId;
    private Date reg_date;

    public Student_Program() {
    }

    public Student_Program(String id, String programId, Date reg_date) {
        this.id = id;
        this.programId = programId;
        this.reg_date = reg_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "Student_Program{" +
                "id='" + id + '\'' +
                ", programId='" + programId + '\'' +
                ", reg_date=" + reg_date +
                '}';
    }
}
