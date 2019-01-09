package com.sergprog;

import com.sergprog.Robot.Commander;
import com.sergprog.Robot.KeyCatcher;
import com.sergprog.Robot.Settings;


import java.awt.*;
import java.io.IOException;

public class Main {
    public static Settings settings = null;


    public static void main(String[] args) throws AWTException, IOException {
        settings = Settings.LoadSettings();
        new KeyCatcher(new Commander(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()));

    }


}

