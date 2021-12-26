package lk.ijse.pos.hibernate.view.tm;

public class Program_fee {
    private String programId;
    private double fee;

    public Program_fee(String programId, double fee) {
        this.programId = programId;
        this.fee = fee;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
