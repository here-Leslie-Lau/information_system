package leslie.information_system.service.impl;

import leslie.information_system.entity.Student;
import leslie.information_system.exception.StudentException;
import leslie.information_system.mapper.GradeMapper;
import leslie.information_system.mapper.StudentMapper;
import leslie.information_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public Student login(Student student) throws StudentException {
        Student studentByStudent_username = studentMapper.getStudentByStudent_username(student.getStudent_username());

        if (studentByStudent_username == null)
            throw new StudentException("用户名错误");

        if (!student.getStudent_password().equals(studentByStudent_username.getStudent_password()))
            throw new StudentException("密码错误");

        if (studentByStudent_username.getIsActive() == 0)
            throw new StudentException("该用户还未激活，请先前往邮箱激活！");

        return studentByStudent_username;
    }

    @Override
    public void regist(Student student) throws StudentException {
        Student studentByStudent_username = studentMapper.getStudentByStudent_username(student.getStudent_username());

        if (studentByStudent_username != null)
            throw new StudentException("该用户名已经存在,请重新注册");

        studentMapper.addStudent(student);
    }

    @Override
    public void active(Integer student_id) {
        studentMapper.changeActiveStatus(student_id);
    }

    @Override
    public void update(Student student) {
        studentMapper.updateStudent(student);
    }

    @Override
    public Student getStudentByStudent_name(String student_username) {
        Student studentByStudent_username = studentMapper.getStudentByStudent_username(student_username);

        return studentByStudent_username;
    }

    @Override
    public List<Student> getStudentByDepartment_id(Integer department_id) {
        List<Student> studentByDepartment_id = studentMapper.getStudentByDepartment_id(department_id);

        return studentByDepartment_id;
    }

    @Override
    public Student getStudentByStudent_id(Integer student_id) {
        Student studentByStudent_id = studentMapper.getStudentByStudent_id(student_id);

        return studentByStudent_id;
    }

    //先把该学生的成绩记录删除，再删除该学生
    @Override
    public void deleteStudent(Integer student_id) {
        gradeMapper.deleteGradeByStudent_id(student_id);

        studentMapper.deleteStudent(student_id);
    }


}
