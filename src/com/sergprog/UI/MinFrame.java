package com.sergprog.UI;

import javax.swing.*;

public class MinFrame extends JFrame {
    public MinFrame() {
        super("AntiMouse settings");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,500);
        add(new MainPanel());

    }
}
