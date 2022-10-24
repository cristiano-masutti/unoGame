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
public class DrawTwoTest
{
    private DrawTwo drawTwo1 = new DrawTwo(Colors.RED);
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
        int previousSize = middleGame1.getPlayerHand().size();
        drawTwo1.effect(middleGame1);
        int nextSize = previousSize + 2;
        assertEquals(nextSize, middleGame1.getPlayer(middleGame1.getNextPlayer()).getHand().size());

    }
    
    @Test
    public void testState() {
        assertEquals(States.SPECIAL, drawTwo1.getState());
    }
    
    @Test
    public void testSetColor() {
        drawTwo1.setColor(Colors.YELLOW);
        assertEquals(Colors.RED, drawTwo1.getColor());
    }
    
    @Test
    public void testClearColor() {
        drawTwo1.clearColor();
        assertEquals(Colors.RED, drawTwo1.getColor());
    }
    
    @Test
    public void testCompareValue() {
        DrawTwo drawTwo = new DrawTwo(Colors.YELLOW);
        assertTrue(drawTwo1.compareValue(drawTwo));
    }
    
    @Test
    public void testValueToString() {
        assertEquals("DRAWTWO", drawTwo1.valueToString());
    }
    
    @Test
    public void testThrowAgainstSpecial() {
        Skip skip1 = new Skip(Colors.YELLOW);
        assertFalse(drawTwo1.canThrowAgainstSpecial(skip1));
    }
    
    @Test
    public void testThrowAgainstSpecial1() {
        DrawTwo drawTwo = new DrawTwo(Colors.RED);
        assertTrue(drawTwo1.canThrowAgainstSpecial(drawTwo));
    }
    
    @Test
    public void testThrowAgainstNumber() {
        NumberCards oneYellow = new NumberCards(Colors.YELLOW, 1);
        assertFalse(drawTwo1.canThrowAgainstNumber(oneYellow));
    }
    
    @Test
    public void testThrowAgainstNumber1() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(drawTwo1.canThrowAgainstNumber(oneRed));
    }
    
    @Test
    public void testCanThrow() {
        NumberCards oneRed = new NumberCards(Colors.RED, 1);
        assertTrue(oneRed.canThrow(drawTwo1));
    }
}
