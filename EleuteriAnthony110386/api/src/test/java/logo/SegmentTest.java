package logo;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class SegmentTest{

    @Test
    public void segmentSizeTest(){
        var segment1  = new Segment(0,0,1,1, SegmentType.STRAIGHT, new Direction(315),0, Color.BLACK,1);
        var segment2 = new Segment(0,0,2,0,SegmentType.STRAIGHT,new Direction(0),0, Color.BLACK,1);
        var segment3 = new Segment(2,0,0,0,SegmentType.STRAIGHT,new Direction(180),0, Color.BLACK,1);
        var segment4 = new Segment(0,0,0,5,SegmentType.STRAIGHT,new Direction(270),0, Color.BLACK,1);
        var segment5 = new Segment(10,10,0,0,SegmentType.STRAIGHT,new Direction(135),0, Color.BLACK,1);
        var segment6 = new Segment(0,5,0,0,SegmentType.STRAIGHT,new Direction(90),0, Color.BLACK,1);

        assertEquals(1, (int)segment1.getLength());
        assertEquals(2, (int)segment2.getLength());
        assertEquals(2, (int)segment3.getLength());
        assertEquals(5, (int)segment4.getLength());
        assertEquals(14, (int)segment5.getLength());
        assertEquals(5, (int)segment6.getLength());

    }

}