package beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty implements Serializable {
    private int id;
    private String facultyName;
    private Time time;
    private Teacher teacher;
    private List<Student> student;

    public Faculty() {
        student = new ArrayList<>();
    }

    public Faculty(int id, String facultyName, Time time, Teacher teacher){
        this();
        this.teacher = teacher;
        this. facultyName = facultyName;
        this. id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFacultyName(String facultyName){
        this.facultyName = facultyName;
    }

    public String getFacultyName(){
        return facultyName;
    }

    public void setTime(Time time){
        this.time = time;
    }

    public Time getTime(){
        return time;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void addStudent(Student student){
        this.student.add(student);
    }

    public Student getStudent(int index){
        return this.student.get(index);
    }

    public void setStudent(List<Student> student){
        this.student = student;
    }

    public List<Student> getStudent(){
        return this.student;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(this == o){
            return true;
        }

        Faculty that = (Faculty) o;

        if(!facultyName.equals(that.facultyName) || !time.equals(that.time) || !teacher.equals(that.teacher) ||  !student.equals(that.student) || !(id!=that.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,facultyName, time, teacher,student);
    }

    @Override
    public String toString() {

        return "id:"+id + " Faculty name:" + facultyName +" "+" Time start:"+ time+" "+"Teacher:"+teacher+"Student:"+student+'\n';
    }

}
