package testbed.demo.tests;

import library.dynamics.Body;
import library.geometry.Circle;
import library.geometry.Polygon;
import library.dynamics.World;
import library.math.Vectors2D;
import testbed.demo.TestBedWindow;

public class Raycast {
    public static void load(TestBedWindow testBedWindow) {
        testBedWindow.setWorld(new World(new Vectors2D(0, -9.81)));
        World temp = testBedWindow.getWorld();

        {
            Body b1 = new Body(new Polygon(20.0, 20.0), 0, -100);
            b1.setDensity(0);
            temp.addBody(b1);

            Body b2 = new Body(new Circle(20), 0, 100);
            b2.setDensity(1);
            temp.addBody(b2);
        }
    }
}