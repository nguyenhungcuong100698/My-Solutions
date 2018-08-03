/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Student.Student;
import dao.studentDAO;
import gui.studentTableModel;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class studentManager {

    private ArrayList<Student> myStudents;
    private studentDAO myDao;
    
    public studentManager() {
        myDao = new studentDAO();
        myStudents = myDao.readByte();
    }

    public void doSaveData(){
        myDao.saveAsByte(myStudents);
    }

    public Student findById(String id) {
        for (Student i : myStudents) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }
    public studentTableModel getStudentTableModel(){
        return new studentTableModel(myStudents);
    }
    public boolean addStudent(String id, String lastName, String midName, String firstName, int yearOfBirth, String gender, String schoolStage) {
        if (this.findById(id) == null) {
            this.myStudents.add(new Student(id, lastName, midName, firstName, yearOfBirth, gender, schoolStage));
            return true;
        }
        return false;
    }
    public ArrayList getListStudent(){
        return this.myStudents;
    }
    public int getListCount(){
        return this.myStudents.size();
    }
}
