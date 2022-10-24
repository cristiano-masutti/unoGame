package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WildTest.
 *
 *  @author masutc@usi.ch fontani@usi.ch.
 * @version 20/05/2022
 */
public class WildTest
{
    private MiddleGame middleGame1 = new MiddleGame(new NormalCardsDeck(), new Discarded());
    private Wild wild1 = new Wild();
    private DrawTwo drawTwo1 = new DrawTwo(Colors.RED);
    private NumberCards unoRed = new NumberCards(Colors.RED, 1);
    
    
    @Test
    public void testEffect() {
        wild1.effect(middleGame1);
        assertEquals(middleGame1, middleGame1);
    }
    
    @Test 
    public void testSetColor() {
        wild1.setColor(Colors.RED);
        assertEquals(Colors.RED, wild1.getColor());
    }
    
    @Test 
    public void testGetColor() {
        assertEquals(null, wild1.getColor());
    }
    
    @Test 
    public void testValueToString() {
        assertEquals("WILD", wild1.valueToString());
    }
    
    @Test 
    public void testColorToString() {
        wild1.setColor(Colors.RED);
        assertEquals("RED", wild1.colorToString());
    }
    
    @Test
    public void testCanThrowAgainstSpecial() {
        wild1.setColor(Colors.RED);
        assertTrue(wild1.canThrowAgainstSpecial(drawTwo1));
    }
    
    @Test
    public void testCanThrowAgainstSpecial1() {
        wild1.setColor(Colors.BLUE);
        assertFalse(wild1.canThrowAgainstSpecial(drawTwo1));
    }
    
    @Test
    public void canThrowAgainstNumber() {
        wild1.setColor(Colors.RED);
        assertTrue(wild1.canThrowAgainstNumber(unoRed));
    }
    
    @Test
    public void canThrowAgainstNumber1() {
        wild1.setColor(Colors.YELLOW);
        assertFalse(wild1.canThrowAgainstNumber(unoRed));
    }
    
    @Test
    public void testCanBeFirst() {
        assertFalse(wild1.canBeFirst());
    }
    
    @Test
    public void testClearColor() {
        wild1.clearColor();
        assertEquals(null, wild1.getColor());
    }
}
