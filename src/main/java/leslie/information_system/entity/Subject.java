package leslie.information_system.entity;

import java.io.Serializable;

public class Subject implements Serializable {
    private Integer subject_id;
    private String subject_name;
    private Department department;

    public Integer getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Integer subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subject_id +
                ", subject_name='" + subject_name + '\'' +
                ", department=" + department +
                '}';
    }
}
