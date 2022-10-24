package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SkipDrawTest.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class SkipDrawTest
{
    private SkipDraw skipDraw1 = new SkipDraw(Colors.RED);
    private MiddleGame middleGame1;
    
    @Test
    public void testEffect() {
        skipDraw1.effect(middleGame1);
        assertEquals(middleGame1, middleGame1);
    }
    
    @Test
    public void testState() {
        assertEquals(States.SPECIAL, skipDraw1.getState());
    }
    
    @Test
    public void testSetColor() {
        skipDraw1.setColor(Colors.YELLOW);
        assertEquals(Colors.RED, skipDraw1.getColor());
    }
    
    @Test
    public void testClearColor() {
        skipDraw1.clearColor();
        assertEquals(Colors.RED, skipDraw1.getColor());
    }
}
