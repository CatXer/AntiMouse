package com.sergprog.UI;

import javax.swing.*;

public class Panel extends JPanel {

    private JFrame jf;

    public Panel(){
        jf = new JFrame("AntiMouse settings");
        jf.setLocationRelativeTo(null);
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        jf.add(this);
        jf.setVisible(true);
    }

}
