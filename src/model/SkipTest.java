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
public class SkipTest
{
    private Skip skip1 = new Skip(Colors.RED);
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
        skip1.effect(middleGame1);
        assertEquals(1, middleGame1.getCurrentPlayer());
    }
    
    @Test
    public void testState() {
        assertEquals(States.NORMAL, skip1.getState());
    }
    
    @Test
    public void testSetColor() {
        skip1.setColor(Colors.YELLOW);
        assertEquals(Colors.RED, skip1.getColor());
    }
    
    @Test
    public void testClearColor() {
        skip1.clearColor();
        assertEquals(Colors.RED, skip1.getColor());
    }
    
    @Test
    public void testCompareValue() {
        DrawTwo drawTwo = new DrawTwo(Colors.YELLOW);
        assertFalse(skip1.compareValue(drawTwo));
    }
    
    @Test
    public void testValueToString() {
        assertEquals("SKIP", skip1.valueToString());
    }
    
    @Test
    public void testThrowAgainstSpecial() {
        DrawTwo drawTwo = new DrawTwo(Colors.YELLOW);
        assertFalse(skip1.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstSpecial1() {
        DrawTwo drawTwo = new DrawTwo(Colors.RED);
        assertTrue(skip1.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstNumber() {
        NumberCards oneYellow = new NumberCards(Colors.YELLOW, 1);
        assertFalse(skip1.canThrowAgainstNumber(oneYellow));
    }
    
    @Test
    public void testThrowAgainstNumber1() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(skip1.canThrowAgainstNumber(oneRed));
    }
    
    @Test
    public void testCanThrow() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(skip1.canThrow(oneRed));
    }
}
