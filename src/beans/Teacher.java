package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher implements Serializable {

    private int id;
    private String name;
    private String surname;
    private List<Faculty> faculty;

    public Teacher(){
        this.faculty = new ArrayList<Faculty>();
    };

    public Teacher(int id, String name, String surname){
        this();
        this.id = id;
        this.name = name;
        this.surname = surname;

    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFaculty(Faculty faculty){
        this.faculty.add(faculty);
    }

    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(this == o){
            return true;
        }

        Teacher that = (Teacher) o;

        if(!name.equals(that.name) || !surname.equals(that.surname) || !faculty.equals(that.faculty) || !(id!=that.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name, surname, faculty);
    }

    @Override
    public String toString() {
        return "id:"+id + " "+"name:"+" " + name +" surname:"+" "+ surname+" "+" faculty:"+faculty+'\n';
    }

}
