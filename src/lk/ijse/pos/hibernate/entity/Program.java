package lk.ijse.pos.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="program")
public class Program {
    @Id
    private String programId;
    private String program;
    private String duration;
    private double fee;

    @OneToMany(mappedBy = "program", cascade = CascadeType.ALL,orphanRemoval = true)
    private final List<Student_Program> studentList = new ArrayList<>();

    public Program() {
    }

    public Program(String programId, String program, String duration, double fee) {
        this.programId = programId;
        this.program = program;
        this.duration = duration;
        this.fee = fee;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

//    @Override
//    public String toString() {
//        return "Program{" +
//                "programId='" + programId + '\'' +
//                ", program='" + program + '\'' +
//                ", duration='" + duration + '\'' +
//                ", fee=" + fee +
//                ", studentList=" + studentList +
//                '}';
//    }


    @Override
    public String toString() {
        return "Program{" +
                "programId='" + programId + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
