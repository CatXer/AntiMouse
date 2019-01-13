package com.sergprog.UI;

import com.sergprog.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class MainPanel extends JPanel {
    MainPanel() {
        setBackground(Color.BLACK);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(6, 2, 10, 10));

        String[] buttons = {
                "Set Drag daley [_" + Main.settings.FPS + "_]", "set wheel [_" + (Main.settings.scrolling ? "OFF_]" : "ON_]"),
                "Set drag left", "Set drag up", "Set drag down", "Set drag right",
                "left key mouse", "right key mouse", "meddle key mouse",
                "up wheel mouse", "down wheel mouse"
        };

        for (String button : buttons) {
            JButton setB = new JButton(button);
            setB.addActionListener(e -> {
                if (button.equals("set wheel [_OFF_]") || button.equals("set wheel [_ON_]")) {
                    Main.settings.scrolling = !Main.settings.scrolling;
                    setB.setText("set wheel [_" + (Main.settings.scrolling ? "OFF_]" : "ON_]"));
                } else if (button.contains("Set Drag daley [_")) {
                    int daley;
                    do {
                        daley = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Enter drag daley[_" + Main.settings.FPS + "_]", "set daley cursor", JOptionPane.INFORMATION_MESSAGE));
                    } while (daley <= 0);
                    Main.settings.FPS = daley;
                    setB.setText("Set Drag daley [_" + Main.settings.FPS + "_]");
                } else {
                    new TestFrame(button);
                }

                try {
                    Main.settings.SaveSettings();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
            add(setB);
        }
        add(new JLabel(""));
        JButton apply = new JButton("Save");
        apply.addActionListener(e -> {
            try {
                Main.settings.SaveSettings();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
        JButton Exit = new JButton("EXIT");
        Exit.addActionListener(e -> {
            Main.KC.close();
            Main.minFrame.dispose();
        });
        add(apply);
        add(Exit);

        setVisible(true);
    }

}
