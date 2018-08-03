/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import dao.classDAO;
import java.util.ArrayList;
import entity.Class;

/**
 *
 * @author Duong
 */
public class classManager {

    ArrayList<Class> classList;
    private classDAO myDAO;

    public classManager() {
        myDAO = new classDAO();
        classList = myDAO.readListCDasByte();
    }

    public void saveData() {
        this.myDAO.saveListCDasByte(classList);
    }

    public void deleteClass(String n, String a) {
        for (Class i : classList) {
            if (i.getClassSchoolstageID().equals(n)) {
                if (i.getClassName().equals(a)) {
                    this.classList.remove(i);
                    break;
                }
            }
        }
    }

    public boolean classAdd(Class arr) {
        for (Class i : this.classList){
            if (arr.getClassName().equals(i.getClassName())){
                return false;
            }
        }
        classList.add(arr);
        return true;
    }

    public ArrayList<String> getListSchoolstageName() {
        ArrayList<String> resList = new ArrayList();
        for (int i = 0; i < classList.size(); i++) {
            resList.add(classList.get(i).getClassName());
        }
        return resList;
    }

    public ArrayList<String> getListClassByShoolStage(String a) {
        ArrayList<String> resList = new ArrayList();
        for (Class i : classList) {
            if (i.getClassSchoolstageID().equals(a)) {
                resList.add(i.getClassName());
            }
        }
        return resList;
    }

    public ArrayList<Class> getListClass() {
        return this.classList;
    }

}
