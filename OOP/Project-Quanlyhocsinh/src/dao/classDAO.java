/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Class;
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
 * @author Duong
 */
public class classDAO {
    private String pathStr="Data";
    private String fileNameByte="Class_Data_Byte.txt";
    private ArrayList<Class> classList;

    public classDAO() {
        createFolder();
    }
    public void createFolder()
    {
        File folder =new File(pathStr);
        if(folder.exists())
        {
            System.out.println("Folder exist");
        }else
        {
            folder.mkdirs();
            System.out.println("Folder created");
        }
    }
    public void saveListCDasByte(ArrayList<Class> classList) 
    {
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
        try
        {
            fos = new FileOutputStream(pathStr+"//"+fileNameByte);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(classList);
            oos.flush();
            System.out.println("Save successfull");
        }
        catch(FileNotFoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }finally
        {
            try
            {
                fos.close();
                oos.close();
            }catch(IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    public ArrayList<Class> readListCDasByte()
    {
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        ArrayList<Class> classList=new ArrayList<>();
        try{
            fis=new FileInputStream(pathStr+"\\"+fileNameByte);
            ois=new ObjectInputStream(fis);
            classList = (ArrayList<Class>)ois.readObject();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(cdDAO.class.getName()).log(Level.SEVERE, null, ex);
            return classList;
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try{
                if(fis!=null)
                {
                    fis.close();
                ois.close();
                }
                
                        
            } catch (IOException ex) {
                Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return classList;
    }
}

