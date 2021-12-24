package lk.ijse.pos.hibernate.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Student_Program {
    @Id
    private String id;

    @ManyToOne @JoinColumn
    private Student student;

    @ManyToOne @JoinColumn
    private Program program;

    private Date reg_date;

    public Student_Program() {
    }

    public Student_Program(String id, Student student, Program program, Date reg_date) {
        this.id = id;
        this.student = student;
        this.program = program;
        this.reg_date = reg_date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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
                ", student=" + student +
                ", program=" + program +
                ", reg_date=" + reg_date +
                '}';
    }
}
