package com.sergprog;

import com.sergprog.Robot.Commander;
import com.sergprog.Robot.KeyCatcher;

import java.awt.*;

public class Main {



    public static void main(String[] args) throws AWTException {



        Commander commander = new Commander(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
        KeyCatcher kk = new KeyCatcher(commander);


    }
}

