package leslie.information_system.service;

import leslie.information_system.entity.Student;
import leslie.information_system.exception.StudentException;

import java.util.List;

public interface StudentService {

    //登录
    public Student login(Student student) throws StudentException;

    //注册
    public void regist(Student student) throws StudentException;

    //激活
    public void active(Integer student_id);

    //更新操作
    public void update(Student student);

    //根据姓名查找学生
    public Student getStudentByStudent_name(String student_username);

    //根据系id查找名字
    public List<Student> getStudentByDepartment_id(Integer department_id);

    //根据id查找学生
    public Student getStudentByStudent_id(Integer student_id);

    //删除学生
    public void deleteStudent(Integer student_id);
}
