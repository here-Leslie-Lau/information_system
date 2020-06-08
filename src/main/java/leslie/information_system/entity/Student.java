package leslie.information_system.entity;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer student_id;
    private String student_name;
    private String student_username;
    private String student_password;
    private String student_email;
    private String student_phone;
    private String student_address;
    private Integer isActive;
    private Department department;

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_username='" + student_username + '\'' +
                ", student_password='" + student_password + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_phone='" + student_phone + '\'' +
                ", student_address='" + student_address + '\'' +
                ", isActive=" + isActive +
                ", department=" + department +
                '}';
    }
}
