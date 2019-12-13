package beans;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Faculty implements Serializable {
    private int id;
    private String facultyName;
    private Teacher teacher;
    private Student student;

    public Faculty() {

    }

    public Faculty(int id, String facultyName, Teacher teacher, Student student){
        this.student = student;
        this.teacher = teacher;
        this. facultyName = facultyName;
        this. id = id;
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

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }

    public Teacher getTeacher(){
        return teacher;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    public Student getStudent(){
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

        if(!facultyName.equals(that.facultyName) || !teacher.equals(that.teacher) ||  !student.equals(that.student) || !(id!=that.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,facultyName, teacher,student);
    }

    @Override
    public String toString() {

        return "id:"+id + " Faculty name:" + facultyName +" "+"Teacher:"+teacher.toString()+"Student:"+student.toString()+'\n';
    }

}
