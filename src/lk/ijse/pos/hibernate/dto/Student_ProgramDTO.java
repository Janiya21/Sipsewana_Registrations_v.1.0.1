package lk.ijse.pos.hibernate.dto;

import java.util.Date;

public class Student_ProgramDTO {
    private String id;
    private String programId;
    private String fee;

    public Student_ProgramDTO(String programId, String fee) {
        this.programId = programId;
        this.fee = fee;
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

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student_ProgramDTO{" +
                "id='" + id + '\'' +
                ", programId='" + programId + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
