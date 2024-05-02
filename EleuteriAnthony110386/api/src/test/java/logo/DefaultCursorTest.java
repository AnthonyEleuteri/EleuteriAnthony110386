package logo;

import org.junit.Test;
import static org.junit.Assert.*;

public class DefaultCursorTest {

    @Test
    public void setPositionTest(){

        DefaultArea current = new DefaultArea();
        DefaultCursor currentDefaultCursor = current.getAssociatedCursor();

        DefaultPoint p1 = new DefaultPoint(0,0);
        current.setTurtlePosition(p1);
        assertEquals(currentDefaultCursor.getPosition(),p1);

        DefaultPoint p2 = new DefaultPoint(100,200);
        current.setTurtlePosition(p2);
        assertEquals(currentDefaultCursor.getPosition(),p2);

        DefaultPoint p3 = new DefaultPoint(201,199);
        current.setTurtlePosition(p3);
        assertEquals(currentDefaultCursor.getPosition(),p3);

        DefaultPoint p4 = new DefaultPoint(250,299);
        current.setTurtlePosition(p4);
        assertEquals(currentDefaultCursor.getPosition(),p4);

        DefaultPoint p5 = new DefaultPoint(300,301);
        current.setTurtlePosition(p5);
        assertEquals(currentDefaultCursor.getPosition(),p5);

        DefaultPoint p6 = new DefaultPoint(25,25);
        current.setTurtlePosition(p6);
        assertEquals(currentDefaultCursor.getPosition(),p6);

        DefaultPoint p7 = new DefaultPoint(3000,3000);
        assertThrows(IllegalArgumentException.class,()->current.setTurtlePosition(p7));

        DefaultPoint p8 = new DefaultPoint(-1,-1);
        assertThrows(IllegalArgumentException.class,()->current.setTurtlePosition(p8));

    }

}