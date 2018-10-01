package fr.parisnanterre.miage.poa.td0.shapes.implem;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RectangleTest {

    Rectangle r1;

    @BeforeMethod
    public void setUp() throws Exception{
        Point2D p = new Point2D(0,0);
        r1 = new Rectangle(p,4,3);
    }

    @AfterMethod
    public void tearDown() throws Exception{
        r1=null;
    }

    @Test
    public void testPerimeter() throws Exception{
        assertEquals(r1.perimeter(),14);
    }

    @Test
    public void testSurface() {
        assertEquals(r1.surface(),12);
    }
}