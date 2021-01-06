package testbed.demo.tests;

import library.dynamics.ShadowCasting;
import library.dynamics.World;
import library.math.Vectors2D;
import testbed.demo.TestBedWindow;

public class LineOfSight {
    public static final String[] text = {"Line of sight:", "Mouse: Move mouse to change position of raycast", ""};
    public static boolean active = false;
    public static ShadowCasting b;

    public static void load(TestBedWindow testBedWindow) {
        testBedWindow.setWorld(new World(new Vectors2D(0, -9.81)));
        testBedWindow.setCamera(new Vectors2D(-100, 20), 3.3);
        active = true;

        testBedWindow.generateBoxOfObjects();

        b = new ShadowCasting(new Vectors2D(-1000, 0), 11000);
        testBedWindow.add(b);
    }

    public static void setRayCount() {
        text[2] = "No of rays: " + b.getNoOfRays();
    }
}
