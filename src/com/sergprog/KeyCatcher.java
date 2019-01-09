package com.sergprog;


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KeyCatcher extends Thread implements NativeKeyListener {

    private boolean left;
    private boolean up;
    private boolean right;
    private boolean down;

    private boolean run;
    private int daley = 2000;

    private static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
    private Commander commander;

    private HashSet<Integer> pressedCount;
    private int second_daley = 0;

    KeyCatcher(Commander commander) {
        this.commander = commander;
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        logger.setLevel(Level.OFF);
        GlobalScreen.addNativeKeyListener(this);
        pressedCount = new HashSet<>();
        run = true;
        start();
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
       /* String key = String.valueOf(nativeKeyEvent.getKeyChar());
        //System.out.println(nativeKeyEvent.getRawCode() + "] is- " + key);*/
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        int key = nativeKeyEvent.getKeyCode();
        pressedCount.add(key);
        if (!right && key == Settings.LEFT_ID) left = true;
        if (!left && key == Settings.RIGHT_ID) right = true;
        if (!down && key == Settings.UP_ID) up = true;
        if (!up && key == Settings.BOTTOM_ID) down = true;

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        int key = nativeKeyEvent.getKeyCode();
        pressedCount.remove(key);
        if (!right && key == Settings.LEFT_ID) left = false;
        if (!left && key == Settings.RIGHT_ID) right = false;
        if (!down && key == Settings.UP_ID) up = false;
        if (!up && key == Settings.BOTTOM_ID) down = false;

    }


    @Override
    public void run() {
        super.run();
        while (run) {

            if (left) commander.Drag(-1, 0);
            else if (right) commander.Drag(1, 0);
            if (up) commander.Drag(0, -1);
            else if (down) commander.Drag(0, 1);

            if (second_daley != 0 && pressedCount.size() != 0) {
                daley = 20;
                second_daley = 0;
            }

            if (second_daley > 1500) {
                daley = 2000;
            } else {
                second_daley++;
            }
            System.out.println(daley+"    "+ second_daley);
            try {
                sleep(daley);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void close() {
        try {
            GlobalScreen.unregisterNativeHook();
            GlobalScreen.removeNativeKeyListener(this);
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }
}