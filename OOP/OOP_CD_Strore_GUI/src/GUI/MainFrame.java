/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import manager.managerCD;

/**
 *
 * @author TOSHIBA
 */
public class MainFrame extends JFrame {

    Font myFont = new Font("Arial", Font.BOLD, 30);
    JLabel labelTitle = new JLabel("CD STORE");
    private manager.managerCD myManager;
    private JTable myTable = new JTable();
    private JScrollPane myScroll = new JScrollPane();

    public MainFrame(managerCD myManager, String string) {
        super(string);
        this.myManager = myManager;
        this.addListener();
    }
    public void Create(){
        this.fillInTable();
        
        this.myScroll.getViewport().add(this.myTable);
        this.labelTitle.setFont(myFont);
        this.add(this.labelTitle,BorderLayout.NORTH);
        
        this.add(this.myScroll,BorderLayout.WEST);
        
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 500);
        this.setVisible(true);
    }

    public void fillInTable() {
        this.myTable.setModel(myManager.getCDTableModel());
    }

    public void addListener() {
        this.myTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                doClickOnTable();
            }

        });
    }

    public void doClickOnTable() {
        JOptionPane.showMessageDialog(this, "You clicked on the " + this.myTable.getSelectedRow() + " row, " + this.myTable.getSelectedColumn() + " columm", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
