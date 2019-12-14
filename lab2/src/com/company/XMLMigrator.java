package com.company;

import com.company.beans.Faculty;
import com.company.beans.Student;
import com.company.beans.Teacher;

import org.apache.log4j.Logger;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class XMLMigrator {
    private String db_name;
    private Connection establishedConnection;

    private final String insertTeacherQuery = "INSERT INTO teachers (id,Name, Surname) values(?,?,?);";
    private final String insertStudentQuery = "INSERT INTO students (id,Name, Surname) values(?,?,?);";
    private final String insertFacultyQuery = "INSERT INTO faculties (id, FacultyName, teacher, student) values(?,?,?,?);";

    public XMLMigrator(String db_name, Connection connection){
        this.db_name = db_name;
        this.establishedConnection = connection;
    }

    public void MigrateXML(String directoryPath){

        Logger logger = Logger.getLogger(XMLMigrator.class);
        String[] innerDirectories = new File(directoryPath).list();
        XMLValidator xmlValidator = new XMLValidator();
        try{
            for(String dirPath : innerDirectories){
                File directory = new File(directoryPath + "\\" + dirPath);
                if(directory.isDirectory()) {
                    String xsdFilePath = getFilePath(directory.getPath(), "xsd");
                    if(xsdFilePath == null){
                        throw new NullPointerException();
                    }

                    String[] innerXMLFiles = new File(directory.getPath() + "\\xml\\").list();
                    for(String innerXMLFile : innerXMLFiles){
                        if(xmlValidator.ValidateXMLByXSD(new File(directory.getPath() + "\\xml\\" + innerXMLFile), new File(xsdFilePath))){
                            logger.info("Successful validated!");
                            migrate(directory.getPath() + "\\xml\\" + innerXMLFile);
                        }else{
                            System.out.println("XML is not VALID!");
                            logger.info("XML is not VALID!");
                        }
                    }
                }
            }
        }catch (NullPointerException e){
            System.out.println("Exception occured!");
            return;
        }
    }

    private String getFilePath(String path, String toCompare){
        String[] innerDirs = new File(path).list();
        String XSDDirectory = null;

        for(int i = 0; i < innerDirs.length; i++){
            if(innerDirs[i].compareTo(toCompare) == 0){
                XSDDirectory = innerDirs[i];
                break;
            }
        }
        if(XSDDirectory != null){
            String XSDName = new File(path + "\\" + XSDDirectory).list()[0];
            return path + "\\" + XSDDirectory + "\\" + XSDName;
        }
        return null;
    }

    public boolean migrate(String filePath){
        XMLDeserializer xmlDeserializer = new XMLDeserializer();
        Object deserializedObj = null;
        deserializedObj = xmlDeserializer.Deserialize(filePath);
        deserializedObj.getClass();
        if(deserializedObj instanceof Student){
            return migrateStudent((Student)deserializedObj);
        }else if(deserializedObj instanceof Teacher){
            return migrateTeacher((Teacher) deserializedObj);
        }else if(deserializedObj instanceof Faculty){
            return migrateFaculty((Faculty)deserializedObj);
        }

        return  false;
    }
    private boolean migrateTeacher(Teacher teacher){
        PreparedStatement preparedStatement;
        try{
            preparedStatement = establishedConnection.prepareStatement(insertTeacherQuery);
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setString(3, teacher.getSurname());

            if(preparedStatement.executeUpdate() != 1){
                return false;
            }
        }catch (SQLException e){
            return false;
        }
        return true;
    };
    private boolean migrateStudent(Student student){
        PreparedStatement preparedStatement;
        try{
            preparedStatement = establishedConnection.prepareStatement(insertStudentQuery);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSurname());

            if(preparedStatement.executeUpdate() != 1){
                return false;
            }
        }catch (SQLException e){
            return false;
        }
        return true;
    };
    private boolean migrateFaculty(Faculty faculty){
        PreparedStatement preparedStatement;
        try{
            preparedStatement = establishedConnection.prepareStatement(insertFacultyQuery);
            preparedStatement.setInt(1, faculty.getId());
            preparedStatement.setString(2, faculty.getFacultyName());
            preparedStatement.setString(3, faculty.getTeacher().toString());
            preparedStatement.setString(4, faculty.getStudent().toString());
            if(preparedStatement.executeUpdate() != 1){
                return false;
            }
        }catch (SQLException e){
            return false;
        }
        return true;
    };
}
