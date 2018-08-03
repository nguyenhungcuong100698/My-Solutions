/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Student.Student;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author LENOVO
 */
public class studentTableModel extends AbstractTableModel {
    private String[] columnName = {"Student ID","First Name","Middle Name","Last Name","gender","School Stage"};
    private ArrayList<Student> listData = new ArrayList<>();
    private ArrayList<Object[]> listObject = new ArrayList<>();

    public studentTableModel(ArrayList<Student> myStudent) {
        this.listData = myStudent;
        for (Student i:listData){
            Object[] res = {i.getId(),i.getFirstName(),i.getMidName(),i.getLastName(),i.getGender(),i.getShoolStage()};
            this.listObject.add(res);
        }
    }
    
    
    
    @Override
    public int getRowCount() {
        return this.listObject.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnName.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int colIndex) {
        return this.listObject.get(rowIndex)[colIndex];
    }
    @Override
    public String getColumnName(int column) {
        return this.columnName[column];
    }
    
    @Override
    public java.lang.Class getColumnClass(int column) {
        return this.getValueAt(0, column).getClass();
    }

    public Object[] getObjectAtRow(int row) {
        return this.listObject.get(row);
    }
    
}
