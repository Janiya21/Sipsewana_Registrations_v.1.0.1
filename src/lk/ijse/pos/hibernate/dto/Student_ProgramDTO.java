package lk.ijse.pos.hibernate.dto;

import lk.ijse.pos.hibernate.entity.Program;
import lk.ijse.pos.hibernate.entity.Student;

import java.util.Date;

public class Student_ProgramDTO {
    private int id;
    private Program programId;
    private Student stuId;
    private String regDate;
    private String fee;

    public Student_ProgramDTO(int id, Program programId, Student stuId, String regDate) {
        this.id = id;
        this.programId = programId;
        this.stuId = stuId;
        this.regDate = regDate;
    }

    public Student_ProgramDTO(int id, Program programId, Student stuId, String regDate, String fee) {
        this.id = id;
        this.programId = programId;
        this.stuId = stuId;
        this.regDate = regDate;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Student getStuId() {
        return stuId;
    }

    public void setStuId(Student stuId) {
        this.stuId = stuId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student_ProgramDTO{" +
                "id=" + id +
                ", programId=" + programId +
                ", stuId=" + stuId +
                ", regDate='" + regDate + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
