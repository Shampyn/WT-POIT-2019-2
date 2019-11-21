package dao.implementation;

import beans.Student;
import dao.comparator.student.StudentIdComparator;
import dao.comparator.student.StudentNameComparator;
import dao.StudentDAO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLStudentDAO implements StudentDAO {

    private static String filepath = "Students.xml";
    private List<Student> studentsList;

    public  XMLStudentDAO(){
        studentsList = new ArrayList<Student>();
        if(new File(filepath).exists()){
            try{
                LoadStudentsFromFile();
            }
            catch (Exception e){

            }
        }
    }

    private void LoadStudentsFromFile(){
        try{
            XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
            studentsList = (ArrayList<Student>)in.readObject();
        }
        catch (IOException e) {

        }
    }

    private void SaveStudentsToFile(){
        try{
            File file = new File(filepath);
            if(!file.exists()){
                if(!file.createNewFile())
                    throw new IOException();
            }
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            out.writeObject(studentsList);
            out.flush();
            out.close();
        }
        catch(IOException e){

        }
    }

    @Override
    public void AddStudent(Student student) {
        studentsList.add(student);
        SaveStudentsToFile();
    }

    @Override
    public void DeleteStudent(int id) {
        for (Student student : studentsList) {
            if (student.getId() == id) {
                studentsList.remove(student);
            }
        }
        SaveStudentsToFile();
    }

    @Override
    public void UpdateStudent(Student student) {
        for (Student stud : studentsList) {
            if (stud.getId() == student.getId()) {
                studentsList.set(studentsList.indexOf(stud), student);
            }
        }
        SaveStudentsToFile();
    }

    @Override
    public int GetMaxID() {
        int maxID = 0;
        for (Student student : studentsList){
            maxID = student.getId()>maxID?student.getId():maxID;
        }
        return maxID;
    }

    @Override
    public void SortById() {
        studentsList.sort(new StudentIdComparator());
    }

    @Override
    public void SortByStudentName() {
        studentsList.sort(new StudentNameComparator());
    }

    @Override
    public Student SearchById(int id) {
        for (Student student : studentsList) {
            if(student.getId() == (id)){
                return student;
            }
        }
        return null;
    }

    @Override
    public Student SearchByStudentName(String name) {
        for (Student student : studentsList) {
            if(student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> ReadStudent() {
        return studentsList;
    }
}