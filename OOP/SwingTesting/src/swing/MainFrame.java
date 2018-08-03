/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author TOSHIBA
 */
public class MainFrame extends JFrame {

    Font myFont = new Font("Arial", Font.BOLD, 50);
    JLabel label1 = new JLabel("Welcome to hell");

    JTextField txtName = new JTextField(30);

    JButton btnOK = new JButton("Okay");

    JLabel label2 = new JLabel("");

    JButton btnClear = new JButton("Clear");
    JCheckBox chbx = new JCheckBox("game");
    JCheckBox chbx1 = new JCheckBox("movie");
    JCheckBox chbx2 = new JCheckBox("music");

    JRadioButton radioMale = new JRadioButton("Male");
    JRadioButton radioFemale = new JRadioButton("Female");
    JRadioButton radioOther = new JRadioButton("Other");

    ButtonGroup myGroup = new ButtonGroup();

    JComboBox<String> cmbx = new JComboBox<>();

    public MainFrame(String string) {
        super(string);
        this.addListener();
        this.addClearListener();
    }

    private void addClearListener() {
        this.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearData();
            }
        });
    }

    private void addListener() {
        this.btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                printData();
            }
        });
    }

    public void createAndShowUI() {
        this.label1.setFont(myFont);
        super.add(this.label1);

        super.add(this.txtName);

        super.add(this.btnOK);

        this.add(this.btnClear);

        this.label2.setFont(myFont);
        super.add(this.label2);

        this.chbx.setSelected(true);
        super.add(this.chbx);
        super.add(this.chbx1);
        super.add(this.chbx2);

        this.myGroup.add(radioMale);
        this.myGroup.add(radioFemale);
        this.myGroup.add(radioOther);

        this.radioMale.setSelected(true);
        super.add(this.radioMale);
        super.add(this.radioFemale);
        super.add(this.radioOther);

        this.cmbx.addItem("Toshiba");
        this.cmbx.addItem("Sony");
        this.cmbx.addItem("Samsung");
        this.cmbx.addItem("Panasonic");
        super.add(this.cmbx);

        this.pack();
        super.setLayout(new FlowLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(400, 300);
        super.setVisible(true);

    }

    public void clearData() {
        this.txtName.setText("");
        this.label2.setText("");
        this.txtName.setEnabled(true);
    }

    public void printData() {
        this.label2.setText("Hello " + this.txtName.getText());
        this.txtName.setEnabled(false);

        System.out.println(this.cmbx.getSelectedItem());
    }
}
