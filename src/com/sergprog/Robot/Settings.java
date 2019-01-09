package com.sergprog.Robot;

import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;

public class Settings {

    int TIME_REALISE = 15;
    static final int FPS = 20;
    private static String path = "./config.conf";

    public int DragSpeed = 10;
    public int WheelSpeed = 1;

    public int LEFT_ID = 57419;
    public int UP_ID = 57416;
    public int RIGHT_ID = 57421;
    public int DOWN_ID = 57424;
    public int LKM_ID = 53;
    public int PKM_ID = 43;
    public int UP_WHEEL = 26;
    public int DOWN_WHEEL = 27;
    public int PRESS_WHEEL = 40;

    public boolean scrolling = true;
    public String LEFT_ID_DESC;
    public String UP_ID_DESC;
    public String DOWN_ID_DESC;
    public String RIGHT_ID_DESC;
    public String LKM_ID_DESC;
    public String PKM_ID_DESC;
    public String PRESS_WHEEL_DESC;
    public String UP_WHEEL_DESC;
    public String DOWN_WHEEL_DESC;


    public static Settings LoadSettings() throws IOException {
        Gson g = new Gson();

        File f = new File(path);
        if (!f.exists() && f.createNewFile()) {
            Settings base = new Settings();
            base.SaveSettings();
        }
        FileReader reader = new FileReader(f);
        Scanner scanner = new Scanner(reader);
        String sett = scanner.nextLine();
        scanner.close();
        reader.close();
        return g.fromJson(sett, Settings.class);
    }

    public void SaveSettings() throws IOException {
        Gson g = new Gson();
        String s = g.toJson(this);
        FileWriter writer = new FileWriter(path);
        writer.write(s);
        writer.close();
    }

}
