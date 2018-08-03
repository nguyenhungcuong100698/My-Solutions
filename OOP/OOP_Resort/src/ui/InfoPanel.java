/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author TOSHIBA
 */
public class InfoPanel extends JPanel {
    Font myFont1 = new Font("Arial", Font.BOLD, 30);
    Font myFont2 = new Font("Arial", Font.BOLD, 20);
    JLabel lable1 = new JLabel("RESORT PRICE CALCULATOR");
    JLabel label2 = new JLabel("Base Price For A Room Is 200$");
    JLabel label3 = new JLabel("Choose options that you want");

    public InfoPanel() {
        super();
        this.createAndShowGUI();
    }
    private void createAndShowGUI(){
        this.lable1.setFont(myFont1);
        this.add(this.lable1);
        this.label2.setFont(myFont2);
        this.add(this.label2);
        this.label3.setFont(myFont2);
        this.add(this.label3);
    }
    
}
