package lk.ijse.pos.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    /*@GeneratedValue*/
    @GeneratedValue(strategy = GenerationType.AUTO)/*(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)*/
    private int id;
    private String name;
    private String dob;
    private String email;
    private String address;
    private String tel;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Student_Program> programList = new ArrayList<>();

    public Student() {
    }

    public Student(int id, String name, String dob, String email, String address, String tel) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public List<Student_Program> getProgramList() {
        return programList;
    }
}
