package lk.ijse.pos.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="student_program")
public class Student_Program {
    @Id
    /*@GeneratedValue*/
    @GeneratedValue(strategy = GenerationType.AUTO)/*(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)*/
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="program_id")
    private Program program;

    private String reg_date;

    public Student_Program() {
    }

    public Student_Program(Student student, Program program, String reg_date) {
        this.student = student;
        this.program = program;
        this.reg_date = reg_date;
    }

    public Student_Program(int id, Student student, Program program, String reg_date) {
        this.id = id;
        this.student = student;
        this.program = program;
        this.reg_date = reg_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "Student_Program{" +
                "id='" + id + '\'' +
                ", student=" + student +
                ", program=" + program +
                ", reg_date='" + reg_date + '\'' +
                '}';
    }
}
