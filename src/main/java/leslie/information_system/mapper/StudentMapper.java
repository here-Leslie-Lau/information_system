package leslie.information_system.mapper;

import leslie.information_system.entity.Student;

import java.util.List;

public interface StudentMapper {

    //根据学生用户名查找学生
    public Student getStudentByStudent_username(String student_username);

    //添加学生
    public Integer addStudent(Student student);

    //根据id查找
    public Student getStudentByStudent_id(Integer student_id);

    //根据系查询学生
    public List<Student> getStudentByDepartment_id(Integer department_id);

    //根据id查找学生改变激活状态为激活
    public void changeActiveStatus(Integer student_id);

    //更新学生信息
    public Integer updateStudent(Student student);

    //删除学生
    public void deleteStudent(Integer student);
}
