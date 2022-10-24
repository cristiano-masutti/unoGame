package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SkipDrawTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class NumberCardsTest
{
    private NumberCards oneRed = new NumberCards(Colors.RED, 1);
    private MiddleGame middleGame1;
    
    @Test
    public void testEffect() {
        oneRed.effect(middleGame1);
        assertEquals(middleGame1, middleGame1);
    }
    
    @Test
    public void testState() {
        assertEquals(States.NORMAL, oneRed.getState());
    }
    
    @Test
    public void testSetColor() {
        oneRed.setColor(Colors.YELLOW);
        assertEquals(Colors.RED, oneRed.getColor());
    }
    
    @Test
    public void testClearColor() {
        oneRed.clearColor();
        assertEquals(Colors.RED, oneRed.getColor());
    }
    
    @Test
    public void testValueToString() {
        assertEquals("1", oneRed.valueToString());
    }
    
    @Test
    public void testThrowAgainstSpecial() {
        DrawTwo drawTwo = new DrawTwo(Colors.YELLOW);
        assertFalse(oneRed.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstSpecial1() {
        DrawTwo drawTwo = new DrawTwo(Colors.RED);
        assertTrue(oneRed.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstNumber() {
        NumberCards fourYellow = new NumberCards(Colors.YELLOW, 4);
        assertFalse(fourYellow.canThrow(oneRed));
    }
    
    @Test
    public void testThrowAgainstNumber1() {
        NumberCards twoRed = new NumberCards(Colors.RED, 2);
        assertTrue(twoRed.canThrowAgainstNumber(oneRed));
    }
    
    @Test
    public void testCanThrow() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(oneRed.canThrow(oneRed));
    }
    
    @Test
    public void testGetPoint() {
        assertEquals(1, oneRed.getPoints());
    }
    
    @Test
    public void testColorToString() {
        assertEquals("RED", oneRed.colorToString());
    }
    
    @Test
    public void testThrowAgainstBlackCard() {
        Wild wild1 = new Wild();
        wild1.setColor(Colors.RED);
        assertTrue(oneRed.canThrowAgainstBlack(wild1));
    }
    
    @Test
    public void testThrowAgainstBlackCard1() {
        Wild wild1 = new Wild();
        wild1.setColor(Colors.YELLOW);
        assertFalse(oneRed.canThrowAgainstBlack(wild1));
    }
}
