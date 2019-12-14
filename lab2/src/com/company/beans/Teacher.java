package com.company.beans;

import java.io.Serializable;
import java.util.Objects;

public class Teacher implements Serializable {

    private int id;
    private String name;
    private String surname;


    public Teacher(){

    };

    public Teacher(int id, String name, String surname){

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




    @Override
    public boolean equals(Object o){
        if(o == null || o.getClass() != getClass()){
            return false;
        }
        if(this == o){
            return true;
        }

        Teacher that = (Teacher) o;

        if(!name.equals(that.name) || !surname.equals(that.surname)  || !(id!=that.id)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,name, surname);
    }

    @Override
    public String toString() {
        return "id:"+id + " "+"name:"+" " + name +" surname:"+" "+ surname+" "+'\n';
    }

}
