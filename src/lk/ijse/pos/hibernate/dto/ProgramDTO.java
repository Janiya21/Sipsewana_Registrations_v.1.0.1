package lk.ijse.pos.hibernate.dto;

public class ProgramDTO {
    private String programId;
    private String program;
    private String duration;
    private double fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String programId) {
        this.programId = programId;
    }

    public ProgramDTO(String programId, double fee) {
        this.programId = programId;
        this.fee = fee;
    }

    public ProgramDTO(String programId, String program, String duration, double fee) {
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

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "programId='" + programId + '\'' +
                ", program='" + program + '\'' +
                ", duration='" + duration + '\'' +
                ", fee=" + fee +
                '}';
    }
}
