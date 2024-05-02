package logo;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class InstructionTest{

    @Test
    public void testForward() {
        var currentArea = new DefaultArea();

        ArrayList<String> movement1 = new ArrayList<>();
        movement1.add("50");
        var point1 = new DefaultPoint(350,200);
        var rule1 = new Instruction(currentArea, ActionEnum.FORWARD,movement1);
        assertEquals(point1,currentArea.getAssociatedCursor().getPosition());

        ArrayList<String> movement2 = new ArrayList<>();
        movement2.add("1");
        var point2 = new DefaultPoint(301,200);
        var rule2 = new Instruction(currentArea, ActionEnum.FORWARD,movement2);
        assertEquals(point2,currentArea.getAssociatedCursor().getPosition());


        ArrayList<String> movement3 = new ArrayList<>();
        movement1.add("150");
        var point3 = new DefaultPoint(450,200);
        var rule3 = new Instruction(currentArea, ActionEnum.FORWARD,movement3);
        assertEquals(point3,currentArea.getAssociatedCursor().getPosition());

        ArrayList<String> movement4 = new ArrayList<>();
        movement4.add("200");
        var point4 = new DefaultPoint(500,200);
        var rule4 = new Instruction(currentArea, ActionEnum.FORWARD,movement4);
        assertEquals(point4,currentArea.getAssociatedCursor().getPosition());

        /*
                    -----CAMBIO DI DIREZIONE-----
         */
        currentArea.getAssociatedCursor().setDir(new Direction(270));

        ArrayList<String> movement5 = new ArrayList<>();
        movement5.add("1");
        var point5 = new DefaultPoint(300,201);
        var rule5 = new Instruction(currentArea, ActionEnum.FORWARD,movement5);
        assertEquals(point5,currentArea.getAssociatedCursor().getPosition());


        ArrayList<String> movement6 = new ArrayList<>();
        movement6.add("150");
        var point6 = new DefaultPoint(300,350);
        var rule6 = new Instruction(currentArea, ActionEnum.FORWARD,movement6);
        assertEquals(point6,currentArea.getAssociatedCursor().getPosition());

        ArrayList<String> movement7 = new ArrayList<>();
        movement7.add("200");
        var point7 = new DefaultPoint(300,400);
        var rule7 = new Instruction(currentArea, ActionEnum.FORWARD,movement7);
        assertEquals(point7,currentArea.getAssociatedCursor().getPosition());


    }

    @Test
    public void testBackward() {
        var currentArea = new DefaultArea();

        ArrayList<String> movement1 = new ArrayList<>();
        movement1.add("50");
        var point1 = new DefaultPoint(250,200);
        var rule1 = new Instruction(currentArea, ActionEnum.BACKWARD,movement1);
        assertEquals(point1,currentArea.getAssociatedCursor().getPosition());

        ArrayList<String> movement2 = new ArrayList<>();
        movement2.add("1");
        var point2 = new DefaultPoint(299,200);
        var rule2 = new Instruction(currentArea, ActionEnum.BACKWARD,movement2);
        assertEquals(point2,currentArea.getAssociatedCursor().getPosition());


        ArrayList<String> movement3 = new ArrayList<>();
        movement1.add("150");
        var point3 = new DefaultPoint(150,200);
        var rule3 = new Instruction(currentArea, ActionEnum.BACKWARD,movement1);
        assertEquals(point3,currentArea.getAssociatedCursor().getPosition());

        ArrayList<String> movement4 = new ArrayList<>();
        movement4.add("200");
        var point4 = new DefaultPoint(100,200);
        var rule4 = new Instruction(currentArea, ActionEnum.BACKWARD,movement4);
        assertEquals(point4,currentArea.getAssociatedCursor().getPosition());

        /*
                    -----CAMBIO DI DIREZIONE-----
         */
        currentArea.getAssociatedCursor().setDir(new Direction(270));

        ArrayList<String> movement5 = new ArrayList<>();
        movement5.add("1");
        var point5 = new DefaultPoint(300,199);
        var rule5 = new Instruction(currentArea, ActionEnum.BACKWARD,movement5);
        assertEquals(point5,currentArea.getAssociatedCursor().getPosition());


        ArrayList<String> movement6 = new ArrayList<>();
        movement6.add("150");
        var point6 = new DefaultPoint(300,50);
        var rule6 = new Instruction(currentArea, ActionEnum.BACKWARD,movement6);
        assertEquals(point6,currentArea.getAssociatedCursor().getPosition());

        ArrayList<String> movement7 = new ArrayList<>();
        movement7.add("200");
        var point7 = new DefaultPoint(300,0);
        var rule7 = new Instruction(currentArea, ActionEnum.BACKWARD,movement7);
        assertEquals(point7,currentArea.getAssociatedCursor().getPosition());

    }

    @Test
    public void testLeft() {
        var currentArea = new DefaultArea();
        ArrayList<String> movement1 = new ArrayList<>();
        movement1.add("50");
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.LEFT, movement1);

        assertEquals(new Direction(50), currentArea.getAssociatedCursor().getDirection());

    }

    @Test
    public void testRight() {
        var currentArea = new DefaultArea();
        ArrayList<String> movement1 = new ArrayList<>();
        movement1.add("180");
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.RIGHT, movement1);

        assertEquals(new Direction(180), currentArea.getAssociatedCursor().getDirection());

    }

    @Test
    public void testClearScreen() {
        var currentArea = new DefaultArea();
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.CLEARSCREEN, new ArrayList<>());

        assertEquals(new LinkedList<Segment>(),currentArea.getDraw());
    }

    @Test
    public void testSetPenUp() {
        var currentArea = new DefaultArea();
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.PENUP, new ArrayList<>());

        assertFalse(currentArea.getAssociatedCursor().isPenDown());

    }

    @Test
    public void testSetPenDown() {
        var currentArea = new DefaultArea();
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.PENDOWN, new ArrayList<>());

        assertTrue(currentArea.getAssociatedCursor().isPenDown());
    }

    @Test
    public void testHome() {
        var currentArea = new DefaultArea();
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.HOME, new ArrayList<>());
        DefaultPoint HOME = DefaultCursor.getHOME();

        assertEquals(HOME ,currentArea.getAssociatedCursor().getPosition());

    }

    @Test
    public void testSetPenColor() {
        var currentArea = new DefaultArea();


        ArrayList<String> colors = new ArrayList<>(3);
        colors.add(0,"2");
        colors.add(1,"10");
        colors.add(2,"240");
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.SETPENCOLOR,colors);
        assertEquals(new Color(2,10,240), currentArea.getAssociatedCursor().getColorLine());


        ArrayList<String> colors2 = new ArrayList<>(3);
        colors.add(0,"254");
        colors.add(1,"254");
        colors.add(2,"254");
        Instruction instruction2 = new Instruction(currentArea,ActionEnum.SETPENCOLOR,colors2);
        assertEquals(new Color(254,254,254), currentArea.getAssociatedCursor().getColorLine());


        ArrayList<String> colors3 = new ArrayList<>(3);
        colors.add(0,"1");
        colors.add(1,"1");
        colors.add(2,"1");
        Instruction instruction3 = new Instruction(currentArea,ActionEnum.SETPENCOLOR,colors3);
        assertEquals(new Color(1,1,1), currentArea.getAssociatedCursor().getColorLine());


        ArrayList<String> colors4 = new ArrayList<>(3);
        colors.add(0,"1");
        colors.add(1,"2");
        colors.add(2,"3");
        Instruction instruction4 = new Instruction(currentArea,ActionEnum.SETPENCOLOR,colors4);
        assertEquals(new Color(1,2,3), currentArea.getAssociatedCursor().getColorLine());


        ArrayList<String> colors5 = new ArrayList<>(3);
        colors.add(0,"10");
        colors.add(1,"10");
        colors.add(2,"254");
        Instruction instruction5 = new Instruction(currentArea,ActionEnum.SETPENCOLOR,colors5);
        assertEquals(new Color(10,10,254), currentArea.getAssociatedCursor().getColorLine());




    }

    @Test
    public void testSetFillColor() {
        var currentArea = new DefaultArea();


        ArrayList<String> colors = new ArrayList<>(3);
        colors.add("2");
        colors.add("10");
        colors.add("244");
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.SETFILLCOLOR,colors);
        assertEquals(new Color(2,10,244), currentArea.getAssociatedCursor().getColorArea());


        ArrayList<String> colors2 = new ArrayList<>(3);
        colors.add("254");
        colors.add("254");
        colors.add("254");
        Instruction instruction2 = new Instruction(currentArea,ActionEnum.SETFILLCOLOR,colors2);
        assertEquals(new Color(254,254,254), currentArea.getAssociatedCursor().getColorArea());


        ArrayList<String> colors3 = new ArrayList<>(3);
        colors.add("1");
        colors.add("1");
        colors.add("1");
        Instruction instruction3 = new Instruction(currentArea,ActionEnum.SETFILLCOLOR,colors3);
        assertEquals(new Color(1,1,1), currentArea.getAssociatedCursor().getColorArea());


        ArrayList<String> colors4 = new ArrayList<>(3);
        colors.add("1");
        colors.add("2");
        colors.add("3");
        Instruction instruction4 = new Instruction(currentArea,ActionEnum.SETFILLCOLOR,colors4);
        assertEquals(new Color(1,2,3), currentArea.getAssociatedCursor().getColorArea());


        ArrayList<String> colors5 = new ArrayList<>(3);
        colors.add("10");
        colors.add("10");
        colors.add("254");
        Instruction instruction5 = new Instruction(currentArea,ActionEnum.SETFILLCOLOR,colors5);
        assertEquals(new Color(10,10,254), currentArea.getAssociatedCursor().getColorArea());

    }

    @Test
    public void testSetScreenColor() {
        var currentArea = new DefaultArea();


        ArrayList<String> colors = new ArrayList<>(3);
        colors.add("2");
        colors.add("10");
        colors.add("244");
        Instruction instruction1 = new Instruction(currentArea,ActionEnum.SETSCREENCOLOR,colors);
        assertEquals(new Color(2,10,244), currentArea.getBackGroundColor());


        ArrayList<String> colors2 = new ArrayList<>(3);
        colors.add("254");
        colors.add("254");
        colors.add("254");
        Instruction instruction2 = new Instruction(currentArea,ActionEnum.SETSCREENCOLOR,colors2);
        assertEquals(new Color(254,254,254), currentArea.getBackGroundColor());


        ArrayList<String> colors3 = new ArrayList<>(3);
        colors.add("1");
        colors.add("1");
        colors.add("1");
        Instruction instruction3 = new Instruction(currentArea,ActionEnum.SETSCREENCOLOR,colors3);
        assertEquals(new Color(1,1,1), currentArea.getBackGroundColor());


        ArrayList<String> colors4 = new ArrayList<>(3);
        colors.add("1");
        colors.add("2");
        colors.add("3");
        Instruction instruction4 = new Instruction(currentArea,ActionEnum.SETSCREENCOLOR,colors4);
        assertEquals(new Color(1,2,3), currentArea.getBackGroundColor());


        ArrayList<String> colors5 = new ArrayList<>(3);
        colors.add("10");
        colors.add("10");
        colors.add("254");
        Instruction instruction5 = new Instruction(currentArea,ActionEnum.SETSCREENCOLOR,colors5);
        assertEquals(new Color(10,10,254), currentArea.getBackGroundColor());


    }

    @Test
    public void testSetPenSize() {
        var currentArea = new DefaultArea();


        ArrayList<String> size1 = new ArrayList<>(1);
        size1.add("2");
        var instruction1 = new Instruction(currentArea, ActionEnum.SETPENSIZE, size1);
        assertEquals(2, currentArea.getAssociatedCursor().getPenSize());


        ArrayList<String> size2 = new ArrayList<>(1);
        size2.add("5");
        var instruction2 = new Instruction(currentArea, ActionEnum.SETPENSIZE, size2);
        assertEquals(5, currentArea.getAssociatedCursor().getPenSize());


        ArrayList<String> size3 = new ArrayList<>(1);
        size1.add("10");
        var instruction3 = new Instruction(currentArea, ActionEnum.SETPENSIZE, size3);
        assertEquals(10, currentArea.getAssociatedCursor().getPenSize());


        ArrayList<String> size4 = new ArrayList<>(1);
        size1.add("0");
        assertThrows(IllegalArgumentException.class,
                () -> {
                var instruction4 = new Instruction(currentArea, ActionEnum.SETPENSIZE, size4);
                }
                );




        ArrayList<String> size5 = new ArrayList<>(1);
        size1.add("50");
        var instruction5 = new Instruction(currentArea, ActionEnum.SETPENSIZE, size5);
        assertEquals(50, currentArea.getAssociatedCursor().getPenSize());


        ArrayList<String> size6 = new ArrayList<>(1);
        size1.add("-1");
        assertThrows(IllegalArgumentException.class,
                () -> {
                    var instruction4 = new Instruction(currentArea, ActionEnum.SETPENSIZE, size6);
                }
        );
    }
}