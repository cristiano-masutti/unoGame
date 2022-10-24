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
public class ReverseTest
{
    private Reverse reverse1 = new Reverse(Colors.RED);
    private MiddleGame middleGame1;
    
    @Test
    public void testEffect() {
        GameStarter gameStarter1 = new GameStarter();
        gameStarter1.selectDeck(1);
        gameStarter1.newPlayers(2);
        for (int i = 0; i < 2; i++) {
            gameStarter1.initPlayers("a", i);
        }
        gameStarter1.initialDraw();
        middleGame1 = gameStarter1.startGame();
        reverse1.effect(middleGame1);
        assertFalse(middleGame1.isSenseNormal());
    }
    
    @Test
    public void testState() {
        assertEquals(States.NORMAL, reverse1.getState());
    }
    
    @Test
    public void testSetColor() {
        reverse1.setColor(Colors.YELLOW);
        assertEquals(Colors.RED, reverse1.getColor());
    }
    
    @Test
    public void testClearColor() {
        reverse1.clearColor();
        assertEquals(Colors.RED, reverse1.getColor());
    }
    
    @Test
    public void testCompareValue() {
        DrawTwo drawTwo = new DrawTwo(Colors.YELLOW);
        assertFalse(reverse1.compareValue(drawTwo));
    }
    
    @Test
    public void testValueToString() {
        assertEquals("REVERSE", reverse1.valueToString());
    }
    
    @Test
    public void testThrowAgainstSpecial() {
        DrawTwo drawTwo = new DrawTwo(Colors.YELLOW);
        assertFalse(reverse1.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstSpecial1() {
        DrawTwo drawTwo = new DrawTwo(Colors.RED);
        assertTrue(reverse1.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstNumber() {
        NumberCards oneYellow = new NumberCards(Colors.YELLOW, 1);
        assertFalse(reverse1.canThrowAgainstNumber(oneYellow));
    }
    
    @Test
    public void testThrowAgainstNumber1() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(reverse1.canThrowAgainstNumber(oneRed));
    }
    
    @Test
    public void testCanThrow() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(oneRed.canThrow(reverse1));
    }
}
