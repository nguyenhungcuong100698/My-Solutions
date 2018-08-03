/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author TOSHIBA
 */
public class MainFrame extends JFrame {

    InfoPanel myInfoPane;
    InputPanel myInputPane;

    private void clearListener() {
        myInputPane.btnClear.addActionListener((ActionEvent ae) -> {
            clearData();
        });
    }

    private void calculateListener() {
        myInputPane.btnCalculate.addActionListener((ActionEvent ae) -> {
            calculateAndPrint();
        });
    }

    private void calculateAndPrint() {
        double money = 200;
        if (myInputPane.chbx1.isSelected()) {
            money += 20;
        }
        if (myInputPane.chbx2.isSelected()) {
            money += 50;
        }
        if (myInputPane.chbx3.isSelected()) {
            money += 15;
        }
        if (myInputPane.cmbx.getSelectedIndex() == 0) {
            money *= 0.9;
        } else {
            money *= 1.3;
        }
        String result = "Hello " + myInputPane.txtName.getText() + " Your Payment Is: " + money;
        JOptionPane.showMessageDialog(this, result,"", JOptionPane.INFORMATION_MESSAGE);
        myInputPane.txtName.setEditable(false);
    }

    private void clearData() {

        myInputPane.txtName.setText("");
        myInputPane.txtName.setEditable(true);
    }

    public MainFrame(String string) throws HeadlessException {
        super(string);
        myInfoPane = new InfoPanel();
        myInputPane = new InputPanel();
        this.calculateListener();
        this.clearListener();
    }

    public void CreateAndShowUI() {
        
        this.add(this.myInfoPane);
        this.add(this.myInputPane);
        
        this.pack();
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setVisible(true);
    }

}
