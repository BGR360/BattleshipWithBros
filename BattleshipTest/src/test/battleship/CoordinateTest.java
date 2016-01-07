package battleship;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Ben on 1/7/16.
 *
 */
public class CoordinateTest {

    @Test
    public void testNumToLetter() throws Exception {
        assertEquals(Coordinate.numToLetter(1), 'A');
        assertEquals(Coordinate.numToLetter(2), 'B');
        assertEquals(Coordinate.numToLetter(11), 'K');
        assertEquals(Coordinate.numToLetter(0), 'A' - 1);
        assertEquals(Coordinate.numToLetter(27), 'Z' + 1);
    }

    @Test
    public void testLetterToNum() throws Exception {
        assertEquals(Coordinate.letterToNum('A'), 1);
        assertEquals(Coordinate.letterToNum('B'), 2);
        assertEquals(Coordinate.letterToNum('K'), 11);
        assertEquals(Coordinate.letterToNum('@'), -1);
        assertEquals(Coordinate.letterToNum(' '), -1);
    }

    @Test(dependsOnMethods = {"testStringConstruct", "testLetterNumConstruct", "testNumNumConstruct"})
    public void testEquals() throws Exception {
        Coordinate defaultCoord0 = new Coordinate(2, 2);
        Coordinate defaultCoord1 = new Coordinate(2, 2);
        assertEquals(defaultCoord0, defaultCoord1);

        Coordinate coord0 = new Coordinate("B8");
        Coordinate coord1 = new Coordinate("I8");
        assertNotEquals(coord0, coord1);

        Coordinate coord2 = new Coordinate("B4");
        Coordinate coord3 = new Coordinate('B', 4);
        assertEquals(coord2, coord3);
    }

    @Test(dependsOnMethods = {"testLetterToNum"})
    public void testStringConstruct() throws Exception {
        Coordinate coord0 = new Coordinate("B4");
        Coordinate coord1 = new Coordinate("I8");

        assertEquals(coord0.getRow(), 2);
        assertEquals(coord0.getCol(), 4);
        assertEquals(coord1.getRow(), 9);
        assertEquals(coord1.getCol(), 8);

        Coordinate badCoord0 = new Coordinate("32");
        Coordinate badCoord1 = new Coordinate("!!");

        assertEquals(badCoord0.getRow(), 1);
        assertEquals(badCoord0.getCol(), 1);
        assertEquals(badCoord1.getRow(), 1);
        assertEquals(badCoord1.getCol(), 1);
    }

    @Test(dependsOnMethods = {"testLetterToNum"})
    public void testLetterNumConstruct() throws Exception {
        Coordinate coord0 = new Coordinate('K', 1);
        Coordinate coord1 = new Coordinate('B', 7);

        assertEquals(coord0.getRow(), 11);
        assertEquals(coord0.getCol(), 1);
        assertEquals(coord1.getRow(), 2);
        assertEquals(coord1.getCol(), 7);

        Coordinate badCoord0 = new Coordinate('P', -1);
        Coordinate badCoord1 = new Coordinate('~', 0);

        assertEquals(badCoord0.getRow(), 16);
        assertEquals(badCoord0.getCol(), 1);
        assertEquals(badCoord1.getRow(), 1);
        assertEquals(badCoord1.getCol(), 1);
    }

    @Test
    public void testNumNumConstruct() throws Exception {
        Coordinate coord0 = new Coordinate(5, 1);
        Coordinate coord1 = new Coordinate(7, 7);

        assertEquals(coord0.getRow(), 5);
        assertEquals(coord0.getCol(), 1);
        assertEquals(coord1.getRow(), 7);
        assertEquals(coord1.getCol(), 7);

        Coordinate badCoord0 = new Coordinate(26, 102);
        Coordinate badCoord1 = new Coordinate(34, 3);

        assertEquals(badCoord0.getRow(), 26);
        assertEquals(badCoord0.getCol(), 102);
        assertEquals(badCoord1.getRow(), 1);
        assertEquals(badCoord1.getCol(), 3);
    }

    @Test(dependsOnMethods = {"testNumToLetter", "testStringConstruct"})
    public void testToString() throws Exception {

    }
}