package com.sergprog.Robot;

import com.sergprog.Main;

import java.awt.*;

public class Commander extends Robot {

    public Commander(GraphicsDevice screen) throws AWTException {
        super(screen);
    }

    void Drag(int dx, int dy) {
        Point xy = MouseInfo.getPointerInfo().getLocation();
        mouseMove(xy.x + dx * Main.settings.DragSpeed, xy.y + dy * Main.settings.DragSpeed);
    }

}
