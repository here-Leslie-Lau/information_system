package leslie.information_system.entity;

import java.io.Serializable;

public class Grade implements Serializable {
    private Integer grade_id;
    private String term;    //格式举例,"2017-2018:第一学期",下学期:"2017-2018:第二学期"
    private Subject subject;
    private Student student;
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(Integer grade_id) {
        this.grade_id = grade_id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", term='" + term + '\'' +
                ", subject=" + subject +
                ", student=" + student +
                ", score=" + score +
                '}';
    }
}
