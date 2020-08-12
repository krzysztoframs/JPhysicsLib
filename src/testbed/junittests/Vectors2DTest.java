package testbed.junittests;

import library.math.Vectors2D;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class Vectors2DTest {


    @Test
    public void setUsingDoubleParameters() {
        Vectors2D vec = new Vectors2D(4.0, 2.0);
        vec.set(33.0, 7.0);
        assertEquals(33.0, vec.x);
        assertEquals(7.0, vec.y);
    }

    @Test
    public void setToVector() {
        Vectors2D vec = new Vectors2D(103.2, -2489273423.2);
        vec.set(new Vectors2D(-42.4, 92.1));
        assertEquals(vec.x, -42.4);
        assertEquals(vec.y, 92.1);
    }

    @Test
    public void copy() {
        Vectors2D vec1 = new Vectors2D(1.0, 1.0);
        Vectors2D vec2 = vec1.copy();
        assertNotEquals(vec1, vec1.copy());
        assertEquals(vec1.x, vec2.x);
        assertEquals(vec1.y, vec2.y);
    }

    @Test
    public void negative() {
        Vectors2D vec = new Vectors2D(5.0, -7.0);
        vec.negative();
        assertEquals(vec.x, -5.0);
        assertEquals(vec.y, 7.0);

        Vectors2D vec1 = vec.negative();
        assertEquals(vec1.x, 5.0);
        assertEquals(vec1.y, -7.0);
        assertEquals(vec.x, 5.0);
        assertEquals(vec.y, -7.0);
    }

    @Test
    public void add() {
        Vectors2D vec1 = new Vectors2D(5.0, 2.0);
        Vectors2D vec2 = new Vectors2D(7.0, 1.0);
        vec1.add(vec2);
        assertEquals(12.0, vec1.x);
        assertEquals(3.0, vec1.y);
    }

    @Test
    public void addi() {
        Vectors2D vec1 = new Vectors2D(5.0, 2.0);
        Vectors2D vec2 = new Vectors2D(7.0, 1.0);
        vec2 = vec1.addi(vec2);
        assertEquals(5.0, vec1.x);
        assertEquals(2.0, vec1.y);
        assertEquals(12.0, vec2.x);
        assertEquals(3.0, vec2.y);
    }

    @Test
    public void normal() {
        Vectors2D vec1 = new Vectors2D(0.0, 1.0);
        Vectors2D val = vec1.normal();
        assertEquals(-1.0, val.x);
        assertEquals(0.0, val.y);
    }

    @Test
    public void normalize() {
        Vectors2D vec1 = new Vectors2D(-345.34, 745.0);
        vec1.normalize();
        assertEquals(vec1.length(), 1.0);
        assertEquals(vec1.x, -0.4205573495355269,0.0);
        assertEquals(vec1.y, 0.9072659564602061,0.0);
    }

    @Test
    public void normalizeToOutVector() {
        Vectors2D vec1 = new Vectors2D(-345.34, 745.0);
        Vectors2D out = new Vectors2D();
        vec1.normalize(out);
        assertFalse(vec1.length() == 1.0);

        assertEquals(vec1.x, -345.34);
        assertEquals(vec1.y, 745.0);

        assertEquals(out.x, -0.4205573495355269,0.0);
        assertEquals(out.y, 0.9072659564602061,0.0);
    }

    @Test
    public void distance() {
        Vectors2D vec1 = new Vectors2D(5.0, 2.0);
        Vectors2D vec2 = new Vectors2D(7.0, 1.0);
        double dist = vec1.distance(vec2);
        //square root of 5
        assertEquals(2.2361, dist, 0.0001);
    }

    @Test
    public void subtract() {
        Vectors2D vec1 = new Vectors2D(5.0, 2.0);
        Vectors2D vec2 = new Vectors2D(7.0, 1.0);
        vec1 = vec1.subtract(vec2);
        assertEquals(-2.0, vec1.x);
        assertEquals(1.0, vec1.y);
    }

    @Test
    public void vectorCrossProduct() {
        Vectors2D vec1 = new Vectors2D(2.0, 3.0);
        Vectors2D vec2 = new Vectors2D(5.0, 6.0);
        double i = vec1.crossProduct(vec2);
        assertEquals(-3.0, i);
    }

    @Test
    public void scalarCrossProduct() {
        Vectors2D vec1 = new Vectors2D(2.0, 3.0);
        Vectors2D cross = vec1.crossProduct(4.0);
        assertEquals(2.0, vec1.x);
        assertEquals(3.0, vec1.y);

        assertEquals(-12.0, cross.x);
        assertEquals(8.0, cross.y);
    }

    @Test
    public void scalar() {
        Vectors2D vec1 = new Vectors2D(5.0, 2.0);
        Vectors2D vec2 = vec1.scalar(4.0f);
        assertEquals(5.0, vec1.x);
        assertEquals(2.0, vec1.y);
        assertEquals(20.0, vec2.x);
        assertEquals(8.0, vec2.y);
    }

    @Test
    public void dotProduct() {
        Vectors2D vec1 = new Vectors2D(5.0, 1.0);
        Vectors2D vec2 = new Vectors2D(15.0, 10.0);
        double i = vec1.dotProduct(vec2);
        assertEquals(85.0, i);
    }

    @Test
    public void length() {
        Vectors2D vec1 = new Vectors2D(0, 7);
        double val = vec1.length();
        assertEquals(7.0, val);
    }

    @Test
    public void cross1() {
        Vectors2D vec1 = new Vectors2D(5.03, 1.30);
        Vectors2D w = Vectors2D.cross(vec1, 6);
        assertEquals(7.8, w.x, 1e-15);
        assertEquals(-30.18, w.y, 1e-15);

        vec1 = new Vectors2D(-3.75, 9.34);
        w = Vectors2D.cross(vec1, 1003.4);
        assertEquals(9371.756, w.x, 1e-15);
        assertEquals(3762.75, w.y, 1e-15);
    }

    @Test
    public void cross2() {
        Vectors2D vec1 = new Vectors2D(5.03, 1.30);
        Vectors2D w = Vectors2D.cross(6, vec1);
        assertEquals(-7.8, w.x, 1e-15);
        assertEquals(30.18, w.y, 1e-15);

        vec1 = new Vectors2D(-3.75, 9.34);
        w = Vectors2D.cross(1003.4, vec1);
        assertEquals(-9371.756, w.x, 1e-15);
        assertEquals(-3762.75, w.y, 1e-15);
    }

    @Test
    public void isValid() {
        assertTrue(new Vectors2D(-34234.234234324, -324954.5).isValid());
        assertTrue(new Vectors2D(32454543, 543543534.6).isValid());
        assertTrue(new Vectors2D(Double.MAX_VALUE, -324954.5).isValid());
        assertTrue(new Vectors2D(32454543, -Double.MAX_VALUE).isValid());
        assertFalse(new Vectors2D(32454543, Double.POSITIVE_INFINITY).isValid());
        assertFalse(new Vectors2D(32454543, -Double.POSITIVE_INFINITY).isValid());

        assertFalse(new Vectors2D(Double.POSITIVE_INFINITY, 234.534).isValid());
        assertFalse(new Vectors2D(-Double.POSITIVE_INFINITY, 234.534324).isValid());

        //Has to be double inputs not integer or doesn't detect NAN
        assertFalse(new Vectors2D(0.0 / 0, 234.534).isValid());
        assertFalse(new Vectors2D(34255234.4, 0.0 / 0).isValid());

    }
}