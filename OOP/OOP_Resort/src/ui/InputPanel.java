/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author TOSHIBA
 */
public class InputPanel extends JPanel {

    JLabel labelName = new JLabel("Guest Name: ");
    JTextField txtName = new JTextField(20);
    JCheckBox chbx1 = new JCheckBox("Breakfast $20");
    JCheckBox chbx2 = new JCheckBox("Golf $50");
    JCheckBox chbx3 = new JCheckBox("Pool $15");
    JComboBox<String> cmbx = new JComboBox<>();
    JButton btnCalculate = new JButton("Calculate");
    JButton btnClear = new JButton("Clear");
    
    public InputPanel() {
        super();
        this.createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.add(this.labelName);
        this.add(this.txtName);
        this.add(chbx1);
        this.add(chbx2);
        this.add(chbx3);
        this.cmbx.addItem("Weekdays (-10%)");
        this.cmbx.addItem("Weekend (+30%)");
        this.add(cmbx);
        this.add(btnCalculate);
        this.add(btnClear);
    }

}
