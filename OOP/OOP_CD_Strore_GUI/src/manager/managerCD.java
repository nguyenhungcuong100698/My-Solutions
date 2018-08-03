package manager;


import GUI.CDTableModel;
import entity.CD;
import dao.CdDao;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOSHIBA
 */
public class managerCD {
    private CdDao myDAO;
    private ArrayList<CD> cdList;

    public managerCD() {
        myDAO = new CdDao();
        cdList = new ArrayList<>();
    }
    public boolean saving(){
        myDAO.saveAsByte(cdList);
        return true;
    }
    public int restore(){
        cdList = this.myDAO.readByte();
        return cdList.size();
    }
    public boolean checkCollection(String collection) {
        return collection.equalsIgnoreCase("game") || collection.equalsIgnoreCase("movie") || collection.equalsIgnoreCase("music");
    }

    public boolean checkType(String type) {
        return type.equalsIgnoreCase("audio") || type.equalsIgnoreCase("video");
    }

    public boolean addCD(String id, String collection, String type, String title, double price, int yearRelease) {
        if (searchByID(id) == -1 && checkCollection(collection) && checkType(type)) {
            cdList.add(new CD(id, collection, type, title, price, yearRelease));
            this.saving();
            return true;
        }
        return false;
    }

    public ArrayList searchByInfo(String info) {
        ArrayList<CD> result = new ArrayList<>();
        for (CD cdList1 : cdList) {
            if (cdList1.getCollection().equals(info)||cdList1.getTitle().equals(info)||cdList1.getType().equals(info)) {
                result.add((CD) cdList1);
            }
        }
        return result;
    }

    public int searchByID(String ID) {
        for (int i = 0; i < cdList.size(); i++) {
            if (cdList.get(i).getId().equals(ID)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteByID(CD temp) {
            this.cdList.remove(temp);
            this.saving();
    }
    public ArrayList<CD> showAll(){
     return this.cdList;   
    }
    public CDTableModel getCDTableModel(){
        return new CDTableModel(cdList);
    }
}
