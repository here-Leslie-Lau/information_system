package leslie.information_system.entity;

import java.io.Serializable;

public class DepartmentAdmin implements Serializable {
    private Integer departmentAdmin_id;
    private String departmentAdmin_username;
    private String departmentAdmin_password;
    private String departmentAdmin_name;
    private Department department;

    public Integer getDepartmentAdmin_id() {
        return departmentAdmin_id;
    }

    public void setDepartmentAdmin_id(Integer departmentAdmin_id) {
        this.departmentAdmin_id = departmentAdmin_id;
    }

    public String getDepartmentAdmin_username() {
        return departmentAdmin_username;
    }

    public void setDepartmentAdmin_username(String departmentAdmin_username) {
        this.departmentAdmin_username = departmentAdmin_username;
    }

    public String getDepartmentAdmin_password() {
        return departmentAdmin_password;
    }

    public void setDepartmentAdmin_password(String departmentAdmin_password) {
        this.departmentAdmin_password = departmentAdmin_password;
    }

    public String getDepartmentAdmin_name() {
        return departmentAdmin_name;
    }

    public void setDepartmentAdmin_name(String departmentAdmin_name) {
        this.departmentAdmin_name = departmentAdmin_name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "DepartmentAdmin{" +
                "departmentAdmin_id=" + departmentAdmin_id +
                ", departmentAdmin_username='" + departmentAdmin_username + '\'' +
                ", departmentAdmin_password='" + departmentAdmin_password + '\'' +
                ", departmentAdmin_name='" + departmentAdmin_name + '\'' +
                ", department=" + department +
                '}';
    }
}
