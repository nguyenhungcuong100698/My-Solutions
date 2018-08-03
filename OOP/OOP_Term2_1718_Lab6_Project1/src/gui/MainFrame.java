/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Manager.studentManager;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author LENOVO
 */
public class MainFrame extends JFrame {

    private JButton btn1 = new JButton("Check Total Students");
    private JButton btn2 = new JButton("Add New Student");
    private JButton btn3 = new JButton("Refresh");
    private JButton btn4 = new JButton("Save Data");
    private JTable table;
    private JScrollPane myScroll = new JScrollPane();
    private studentManager myManager;

    public MainFrame(String string) throws HeadlessException {
        super(string);
        myManager = new studentManager();
        table = new JTable(this.myManager.getStudentTableModel());
        this.addListener();
    }

    public MainFrame(studentManager myManager, String string) throws HeadlessException {
        super(string);
        this.myManager = myManager;
        table = new JTable(this.myManager.getStudentTableModel());
        this.addListener();
    }

    private void doClickBtn1() {
        JOptionPane.showMessageDialog(this, "There are " + this.myManager.getListCount() + " students in total", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void doClickBtn2() {
        NewStudentDialog myJDialog = new NewStudentDialog(this, "Add new student", myManager);
        myJDialog.ShowGUI();
    }

    private void doClickBtn3() {
        table = new JTable(this.myManager.getStudentTableModel());
        this.myScroll.getViewport().add(this.table);
    }
    private void doClickBtn4(){
        this.myManager.doSaveData();
    }
    private void addListener() {
        this.btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClickBtn1();
            }
        });
        this.btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClickBtn2();
            }
        });
        this.btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClickBtn3();
            }
        });
        this.btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            doClickBtn4();
            }
        });
    }

    public void ShowGUI() {
        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
        this.add(btn4);

        this.myScroll.getViewport().add(this.table);
        this.add(myScroll);

        this.setLayout(new FlowLayout());

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 200);
        this.setVisible(true);
    }
}
