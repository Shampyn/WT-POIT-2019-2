package dao.implementation;

import beans.Faculty;
import dao.comparator.faculty.FacultyIdComparator;
import dao.comparator.faculty.FacultyNameComparator;
import dao.FacultyDAO;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLFacultyDAO implements FacultyDAO {

    private static String filepath = "Faculties.xml";
    private List<Faculty> FacultyList;


    public  XMLFacultyDAO(){
        FacultyList = new ArrayList<Faculty>();
        if(new File(filepath).exists()){
            try{
                LoadFacultiesFromFile();
            }
            catch (Exception e){

            }
        }
    }

    private void LoadFacultiesFromFile(){
        try{
            XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
            FacultyList = (ArrayList<Faculty>)in.readObject();
        }
        catch (IOException e) {

        }
    }

    private void SaveFacultiesToFile(){
        try{
            File file = new File(filepath);
            if(!file.exists()){
                if(!file.createNewFile())
                    throw new IOException();
            }
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            out.writeObject(FacultyList);
            out.flush();
            out.close();
        }
        catch(IOException e){

        }
    }


    @Override
    public void AddFaculty(Faculty faculty) {
        FacultyList.add(faculty);
        SaveFacultiesToFile();
    }

    @Override
    public void DeleteFaculty(int id) {
        for (Faculty faculty : FacultyList) {
            if (faculty.getId() == id) {
                FacultyList.remove(faculty);
            }
        }
        SaveFacultiesToFile();
    }

    @Override
    public void UpdateFaculty(Faculty faculty) {
        for (Faculty facult : FacultyList) {
            if (facult.getId() == faculty.getId()) {
                FacultyList.set(FacultyList.indexOf(facult), faculty);
            }
        }
        SaveFacultiesToFile();
    }

    @Override
    public int GetMaxID() {
        int maxID = 0;
        for(Faculty faculty: FacultyList){
            maxID = faculty.getId()>maxID?faculty.getId():maxID;
        }
        return maxID;
    }

    @Override
    public void SortById() {
        FacultyList.sort(new FacultyIdComparator());
    }

    @Override
    public void SortByFacultyName() {
        FacultyList.sort(new FacultyNameComparator());
    }

    @Override
    public Faculty SearchByFacultyName(String facultyName) {
        for(Faculty faculty: FacultyList){
            if(faculty.getFacultyName().equals(facultyName)){
                return faculty;
            }
        }
        return null;
    }

    @Override
    public Faculty SearchById(int id) {
        for(Faculty faculty: FacultyList){
            if(faculty.getId() == (id)){
                return faculty;
            }
        }
        return null;
    }

    @Override
    public List<Faculty> ReadFaculty() {
        return FacultyList;
    }
}
