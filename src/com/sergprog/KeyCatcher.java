package com.sergprog;


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class KeyCatcher implements NativeKeyListener {


    private static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());

    KeyCatcher() {

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        logger.setLevel(Level.OFF);
        GlobalScreen.addNativeKeyListener(this);

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        String key = String.valueOf(nativeKeyEvent.getKeyChar());
        System.out.println(nativeKeyEvent.getRawCode() + "] is- " + key);
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        switch (nativeKeyEvent.getKeyCode()) {
            case 14:
                System.out.println("Char//");
                break;
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

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