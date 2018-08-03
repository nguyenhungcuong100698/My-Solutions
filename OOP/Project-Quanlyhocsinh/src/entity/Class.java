/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Duong
 */
public class Class implements Serializable{
   
    private String classSchoolstageID;
    private String className;
    

    public Class(String classSchoolstageID, String className) {
        
        this.classSchoolstageID = classSchoolstageID;
        this.className = className;
    }



    public String getClassSchoolstageID() {
        return classSchoolstageID;
    }

    public String getClassName() {
        return className;
    }
    
}
