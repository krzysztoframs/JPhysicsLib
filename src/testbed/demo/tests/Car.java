package testbed.demo.tests;

import library.World;
import library.math.Vectors2D;
import testbed.demo.TestBedWindow;

public class Car {
    public static void load(TestBedWindow testBedWindow) {
        testBedWindow.createWorld(new World(new Vectors2D(0, -9.81)));
        World temp = testBedWindow.getWorld();


    }
}
