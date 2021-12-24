package lk.ijse.pos.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Student {
    @Id
    private String id;
    private String name;
    private Date dob;
    private String email;
    private String address;
    private int tel;
    private String method;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private final List<Student_Program> programList = new ArrayList<>();

    public Student() {
    }

    public Student(String id, String name, Date dob, String email, String address, int tel, String method) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.tel = tel;
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", method='" + method + '\'' +
                ", programList=" + programList +
                '}';
    }
}
