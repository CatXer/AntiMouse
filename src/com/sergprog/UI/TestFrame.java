package com.sergprog.UI;

import com.sergprog.Main;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TestFrame extends JFrame {

    TestFrame(String sett) {
        super("AntiMouse set key");
        setLocationRelativeTo(null);
        setSize(300, 300);
        KeyPanel panel = new KeyPanel(sett);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                panel.close();
                dispose();
            }
        });
        add(panel);
        setVisible(true);
    }

    class KeyPanel extends JPanel implements NativeKeyListener {

        private Label Butt;
        private int KeyID = 0;
        private String desc = " ";

        KeyPanel(String sett) {
            setLayout(new BorderLayout());

            Butt = new Label("Enter your key");
            Butt.setFont(new Font("Serif", Font.BOLD, 30));
            Butt.setAlignment(Label.CENTER);
            add(Butt, BorderLayout.CENTER);
            JButton confirm = new JButton("Apply");
            confirm.addActionListener(e -> {
                switch (sett) {
                    case "Set drag left":
                        Main.settings.LEFT_ID = KeyID;
                        Main.settings.LEFT_ID_DESC = desc;
                        break;
                    case "Set drag up":
                        Main.settings.UP_ID = KeyID;
                        Main.settings.UP_ID_DESC = desc;
                        break;
                    case "Set drag down":
                        Main.settings.DOWN_ID = KeyID;
                        Main.settings.DOWN_ID_DESC = desc;
                        break;
                    case "Set drag right":
                        Main.settings.RIGHT_ID = KeyID;
                        Main.settings.RIGHT_ID_DESC = desc;
                        break;
                    case "left key mouse":
                        Main.settings.LKM_ID = KeyID;
                        Main.settings.LKM_ID_DESC = desc;
                        break;
                    case "right key mouse":
                        Main.settings.PKM_ID = KeyID;
                        Main.settings.PKM_ID_DESC = desc;
                        break;
                    case "meddle key mouse":
                        Main.settings.PRESS_WHEEL = KeyID;
                        Main.settings.PRESS_WHEEL_DESC = desc;
                        break;
                    case "up wheel mouse":
                        Main.settings.UP_WHEEL = KeyID;
                        Main.settings.UP_WHEEL_DESC = desc;
                        break;
                    case "down wheel mouse":
                        Main.settings.DOWN_WHEEL = KeyID;
                        Main.settings.DOWN_WHEEL_DESC = desc;
                        break;
                }
                close();
                dispose();
            });

            add(confirm, BorderLayout.SOUTH);

            GlobalScreen.addNativeKeyListener(this);
        }

        @Override
        public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

        }

        @Override
        public void nativeKeyPressed(NativeKeyEvent e) {
            KeyID = e.getKeyCode();
            desc = NativeKeyEvent.getKeyText(e.getKeyCode());
            Butt.setText(desc);
        }

        @Override
        public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

        }

        void close() {
            GlobalScreen.removeNativeKeyListener(this);
        }
    }
}
