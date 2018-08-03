/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Manager.studentManager;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author LENOVO
 */
public class NewStudentDialog extends JDialog {

    private JLabel labelID = new JLabel("Student ID: ");
    private JTextField txtID = new JTextField(20);
    private JLabel labelName = new JLabel("Last-Middle-First Name: ");
    private JTextField txtLN = new JTextField(10);
    private JTextField txtMN = new JTextField(10);
    private JTextField txtFN = new JTextField(10);
    private JLabel labelY = new JLabel("Year of birth: ");
    private JTextField txtY = new JTextField(8);
    private JRadioButton rbtnMale = new JRadioButton("Male");
    private JRadioButton rbtnFemale = new JRadioButton("Female");
    private ButtonGroup group = new ButtonGroup();
    private String[] cmbxData = {"Elementary School", "Middle School", "High School"};
    private JComboBox<String> cmbx1 = new JComboBox<>(this.cmbxData);
    private JButton btnSave = new JButton("Save");
    private JButton btnClear = new JButton("Clear");
    private JButton btnCancel = new JButton("Cancel");
    private studentManager myManager;

    public NewStudentDialog(Frame frame, String string,studentManager manager) {
        super(frame, string);
        this.addListener();
        myManager = manager;
    }

    private void addListener() {
        this.btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClickSave();
            }
        });
        this.btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClickClear();
            }
        });
        this.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                doClickCancel();
            }
        });
    }

    private void doClickSave() {
        String id = this.txtID.getText();
        String lastName = this.txtLN.getText();
        String midName = this.txtMN.getText();
        String firstName = this.txtFN.getText();
        int yearOfBirth = Integer.parseInt(this.txtY.getText());
        String gender = (this.rbtnMale.isSelected()) ? "Male" : "Female";
        String schoolStage = (String) this.cmbx1.getSelectedItem();
        if (this.myManager.addStudent(id, lastName, midName, firstName, yearOfBirth, gender, schoolStage)){
            JOptionPane.showMessageDialog(this,"Sucessful", "Information",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,"Unsucessful", "Information", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void doClickClear(){
        this.txtID.setText("");
        this.txtLN.setText("");
        this.txtMN.setText("");
        this.txtFN.setText("");
        this.txtY.setText("");
    }
    public void doClickCancel(){
        this.dispose();
    }
    public void ShowGUI() {
        this.setLayout(new FlowLayout());

        this.add(this.labelID);
        this.add(this.txtID);
        this.add(this.labelName);
        this.add(this.txtFN);
        this.add(this.txtMN);
        this.add(this.txtLN);
        this.add(this.labelY);
        this.add(this.txtY);
        this.add(this.rbtnMale);
        this.add(this.rbtnFemale);
        this.group.add(this.rbtnFemale);
        this.group.add(this.rbtnMale);
        this.add(this.cmbx1);
        this.add(this.btnSave);
        this.add(this.btnClear);
        this.add(this.btnCancel);

        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setSize(500, 200);
        this.setVisible(true);
    }
}
