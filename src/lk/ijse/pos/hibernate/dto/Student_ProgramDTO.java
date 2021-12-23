package lk.ijse.pos.hibernate.dto;

import java.util.Date;

public class Student_ProgramDTO {
    private String id;
    private String programId;

    public Student_ProgramDTO(String id, String programId) {
        this.id = id;
        this.programId = programId;
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

    @Override
    public String toString() {
        return "Student_ProgramDTO{" +
                "id='" + id + '\'' +
                ", programId='" + programId + '\'' +
                '}';
    }
}
