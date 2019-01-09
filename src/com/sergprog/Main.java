package com.sergprog;

import java.awt.*;

public class Main {



    public static void main(String[] args) throws InterruptedException, AWTException {
        Commander commander = new Commander(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice());
        KeyCatcher kk = new KeyCatcher(commander);


    }
}

