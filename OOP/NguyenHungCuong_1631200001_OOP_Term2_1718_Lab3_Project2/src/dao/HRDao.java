/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOSHIBA
 */
public class HRDao {
    private String pathStr = "Data";
    private String fileNameChar = "CD_DATA_Character.txt";
    private String fileNameByte = "CD_DATA_Byte.txt";
    public HRDao() {
        this.createFolder();
    }
    public final void createFolder() {
        File folder = new File(pathStr);
        if (folder.exists()) {
            System.out.println("Folder exists");
        } else {
            folder.mkdirs();
            System.out.println("Folder created");
        }
    }

    public void saveAsByte(ArrayList<Employee.Employee> listEmployee) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(pathStr + "\\" + fileNameByte);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listEmployee);
            oos.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HRDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HRDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(HRDao.class.getName()).log(Level.SEVERE, null, ex);
            } 

        }
    }

    public ArrayList<Employee.Employee> readByte() {
        ArrayList<Employee.Employee> res = new ArrayList<>();
        FileInputStream fis;
        ObjectInputStream ois;
        try {
            fis = new FileInputStream(pathStr + "\\" + fileNameByte);

            ois = new ObjectInputStream(fis);

            res = (ArrayList) ois.readObject();

            fis.close();
            ois.close();

        } catch (FileNotFoundException ex) {
            return res;
        } catch (IOException | ClassNotFoundException ex) {
            return res;
        }
        return res;
    }
}
