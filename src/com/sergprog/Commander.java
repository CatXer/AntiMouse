package com.sergprog;

import java.awt.*;

public class Commander extends Robot {

    Commander(GraphicsDevice screen) throws AWTException {
        super(screen);
    }

    void Drag(int dx, int dy) {
        Point xy = MouseInfo.getPointerInfo().getLocation();
        mouseMove(xy.x + dx * Settings.DragSpeed, xy.y + dy * Settings.DragSpeed);
    }

}
