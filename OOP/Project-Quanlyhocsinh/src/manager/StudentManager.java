/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.studentDAO;
import entity.Student;
import java.util.ArrayList;

/**
 *
 * @author Duong
 */
public class StudentManager {
    private ArrayList<Student> listStudent;
    public dao.studentDAO myDAO;
  

    public StudentManager()
    {
        myDAO = new studentDAO();
        listStudent = myDAO.readListCDasByte();
    }
    public void deleteStudent(String holyName, String firstName, String lastName, String schoolStage, String Class){
        for (int j =0;j<this.listStudent.size();j++){
            Student i=this.listStudent.get(j);
            if (i.getSchoolStage().equals(schoolStage)){
                if (i.getStuClass().equals(Class)){
                    if (i.getHolyName().equals(holyName)){
                        if (i.getLastName().equals(lastName)){
                            if (i.getFirstName().equals(firstName)){
                                this.listStudent.remove(j);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public int findChangeStudent(String holyName, String firstName, String lastName, String schoolStage, String Class){
        for (int k=0;k<listStudent.size();k++){
            Student i = listStudent.get(k);
            if (i.getSchoolStage().equals(schoolStage)){
                if (i.getStuClass().equals(Class)){
                    if (i.getHolyName().equals(holyName)){
                        if (i.getLastName().equals(lastName)){
                            if (i.getFirstName().equals(firstName)){
                                return k;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    public void changeScore(int i, int mieng,int muoilam, int mottiet,int thi)
    {
        this.listStudent.get(i).setMieng(mieng);
        this.listStudent.get(i).setMuoilam(muoilam);
        this.listStudent.get(i).setMottiet(mottiet);
        this.listStudent.get(i).setThi(thi);
                
    }
    public void changeStudent(int i,String holyName, String firstName, String lastName, String schoolStage, String stuClass, String yearOfBirth, String placeOfBirth, String fatherName, String motherName, String phoneNumber, String address ){
        this.listStudent.get(i).setHolyName(holyName);
        this.listStudent.get(i).setFirstName(firstName);
        this.listStudent.get(i).setLastName(lastName);
        this.listStudent.get(i).setSchoolStage(schoolStage);
        this.listStudent.get(i).setStuClass(stuClass);
        this.listStudent.get(i).setYearOfBirth(yearOfBirth);
        this.listStudent.get(i).setPlaceOfBirth(placeOfBirth);
        this.listStudent.get(i).setFatherName(fatherName);
        this.listStudent.get(i).setMotherName(motherName);
        this.listStudent.get(i).setPhoneNumber(phoneNumber);
        this.listStudent.get(i).setAddress(address);
    }
    public boolean addStudent(Student acc)
    {
        if (this.findChangeStudent(acc.getHolyName(), acc.getFirstName(), acc.getLastName(), acc.getSchoolStage(), acc.getStuClass()) == -1){
        this.listStudent.add(acc);         
        return true;
        }
        return false;
    }
    public Student findStudenByName(String name)
    {
        Student acc=null;
        for(int i=0;i<listStudent.size();i++)
        {
            if(this.listStudent.get(i).getLastName().equals(name))
                return this.listStudent.get(i);
        }
        return acc;
    }
    public ArrayList getListStudent()
    {
        return  this.listStudent;
    }
}
