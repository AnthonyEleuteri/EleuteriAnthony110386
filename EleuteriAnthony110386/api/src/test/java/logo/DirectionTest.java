package logo;

import org.junit.Test;

import static logo.Direction.isValid;
import static logo.Direction.oppositeDirection;
import static org.junit.Assert.*;

public class DirectionTest{

    @Test
    public void oppositeDirectionTest() {

        var dir1 = new Direction(0);
        var dir2 = new Direction(90);
        var dir3 = new Direction(180);
        var dir4 = new Direction(270);
        var dir5 = new Direction(360);
        var dir6 = new Direction(45);
        var dir7 = new Direction(135);
        var dir8 = new Direction(225);

        assertEquals(180, oppositeDirection(dir1).getDirectionInDegree());
        assertEquals(270, oppositeDirection(dir2).getDirectionInDegree());
        assertEquals(0, oppositeDirection(dir3).getDirectionInDegree());
        assertEquals(90, oppositeDirection(dir4).getDirectionInDegree());
        assertEquals(180, oppositeDirection(dir5).getDirectionInDegree());
        assertEquals(225, oppositeDirection(dir6).getDirectionInDegree());
        assertEquals(315, oppositeDirection(dir7).getDirectionInDegree());
        assertEquals(45, oppositeDirection(dir8).getDirectionInDegree());
    }

    @Test
    public void isValidTest(){
        assertFalse(isValid(361));
        assertFalse(isValid(1000));
        assertFalse(isValid(3601));
        assertFalse(isValid(3960));

        assertTrue(isValid(0));
        assertTrue(isValid(360));
        assertTrue(isValid(10));
        assertTrue(isValid(1));
        assertTrue(isValid(90));
    }

}