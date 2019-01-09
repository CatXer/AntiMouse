package com.sergprog.UI;

import com.sergprog.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class MainPanel extends JPanel {
    MainPanel() {
        setBackground(Color.BLACK);


       /* setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBorder(new EmptyBorder(new Insets(10, 10, 40, 60)));
        add(new JButton("Button"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(new JButton("Button"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(new JButton("Button"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(new JButton("Button"));*/


        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new GridLayout(6, 2, 10, 10));

        String[] buttons = {
                "Set Drag speed [_" + Main.settings.DragSpeed + "_]", "Set Wheel speed [_" + Main.settings.WheelSpeed + "_]",
                "Set drag left", "Set drag up",
                "Set drag down", "Set drag right", "left key mouse", "right key mouse",
                "meddle key mouse", "set wheel [_" + (Main.settings.scrolling ? "OFF_]" : "ON_]"), "up wheel mouse", "down wheel mouse"
        };

        for (String button : buttons) {
            JButton setB = new JButton(button);
            setB.addActionListener(e -> {
                if (button.equals("set wheel [_OFF_]") || button.equals("set wheel [_ON_]")) {
                    Main.settings.scrolling = !Main.settings.scrolling;
                    setB.setText("set wheel [_" + (Main.settings.scrolling ? "OFF_]" : "ON_]"));
                } else if (button.contains("Set Drag speed [_")) {
                    Main.settings.DragSpeed = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter drag speed[_" + Main.settings.DragSpeed + "_]", "set speed cursor", JOptionPane.INFORMATION_MESSAGE));
                    setB.setText("Set Drag speed [_" + Main.settings.DragSpeed + "_]");
                } else if (button.contains("Set Wheel speed [_")) {
                    Main.settings.WheelSpeed = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Enter wheel speed[_" + Main.settings.WheelSpeed + "_]", "set speed wheel", JOptionPane.INFORMATION_MESSAGE));
                    setB.setText("Set Wheel speed [_" + Main.settings.WheelSpeed + "_]");
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
