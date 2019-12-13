package dao.implementation;


import beans.Teacher;
import dao.comparator.teacher.TeacherIdComparator;
import dao.comparator.teacher.TeacherNameComparator;
import dao.TeacherDAO;
import service.implementation.XSDValidator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLTeacherDAO implements TeacherDAO {

    private static String filepath = "Teachers.xml";
    private List<Teacher> teachersList;
    private Teacher LoggedinTeacher;


    public  XMLTeacherDAO(){
        teachersList = new ArrayList<>();
        if(new File(filepath).exists()){
            try{
                if(new XSDValidator().ValidateXMLByXSD(new File(filepath), new File("Teacher.xsd"))){
                    LoadTeachersFromFile();
                }
                else{
                    System.out.println("Error Loading teachers");
                }
            }
            catch (Exception e){
                System.out.println("Error Loading teachers");
            }
            }
        }


    private void LoadTeachersFromFile(){
        try{
            XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
            teachersList = (ArrayList<Teacher>)in.readObject();
        }
        catch (IOException e) {

        }
    }

    private void SaveTeachersToFile(){
        try{
            File file = new File(filepath);
            if(!file.exists()){
                if(!file.createNewFile())
                    throw new IOException();
            }
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            out.writeObject(teachersList);
            out.flush();
            out.close();
        }
        catch(IOException e){

        }
    }

    @Override
    public void AddTeacher(Teacher teacher) {
        teachersList.add(teacher);
        SaveTeachersToFile();
    }

    @Override
    public void DeleteTeacher(Teacher teacher) {
        teachersList.remove(teacher);
        ChooseTeacher(null);
        SaveTeachersToFile();
    }

    @Override
    public void UpdateTeacher(Teacher teacher) {
        for (Teacher teach : teachersList) {
            if (teach.getId() == teacher.getId()) {
                teachersList.set(teachersList.indexOf(teach), teacher);
            }
        }
        SaveTeachersToFile();
    }

    @Override
    public void ChooseTeacher(Teacher teacher) {
        LoggedinTeacher = teacher;
    }

    @Override
    public Teacher GetLoggedInTeacher() {
        return LoggedinTeacher;
    }

    @Override
    public int GetMaxID() {
        int maxID = 0;
        for (Teacher teacher : teachersList){
            maxID = teacher.getId()>maxID?teacher.getId():maxID;
        }
        return maxID;
    }

    @Override
    public void SortById() {
        teachersList.sort(new TeacherIdComparator());
    }

    @Override
    public void SortByTeacherName() {
        teachersList.sort(new TeacherNameComparator());
    }

    @Override
    public Teacher SearchById(int id) {
        for (Teacher teacher : teachersList) {
            if(teacher.getId() == (id)){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public Teacher SearchByTeacherName(String name) {
        for (Teacher teacher : teachersList) {
            if(teacher.getName().equals(name)){
                return teacher;
            }
        }
        return null;
    }

    @Override
    public List<Teacher> ReadTeacher() {
        return teachersList;
    }
}
