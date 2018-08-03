/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entity.CD;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TOSHIBA
 */
public class CDTableModel extends AbstractTableModel {

    private String[] columnName = {"ID", "Title", "Collection", "Type", "Price"};
    private ArrayList<CD> listData = new ArrayList<>();
    private ArrayList<Object[]> listObject = new ArrayList<>();

    public CDTableModel(ArrayList<CD> listCD) {
        this.listData = listCD;
        for (CD i : listCD) {
            Object[] res = {i.getId(), i.getTitle(), i.getCollection(), i.getType(), i.getPrice()};
            listObject.add(res);
        }
    }

    public Object getObjectAtRow(int row) {
        return this.listData.get(row);
    }

    public java.lang.Class getColumnClass(int columm) {
        return this.getValueAt(0, columm).getClass();
    }

    public String getColumnName(int columm) {
        return this.columnName[columm];
    }

    public int getRowCount() {
        return this.listObject.size();
    }

    public int getColumnCount() {
        return this.columnName.length;
    }

    public Object getValueAt(int rowIndex, int colIndex) {
        return this.listObject.get(rowIndex)[colIndex];
    }

}
