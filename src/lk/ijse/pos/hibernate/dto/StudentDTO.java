package lk.ijse.pos.hibernate.dto;

import java.util.Date;

public class StudentDTO {
    private int id;
    private String name;
    private Date dob;
    private String email;
    private String address;
    private String tel;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, String email, String address, String tel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.tel = tel;
    }

    public StudentDTO(int id, String name, Date dob, String email, String address, String method, String tel) {
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
