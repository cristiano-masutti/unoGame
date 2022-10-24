package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WildTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DrawFourTest
{
    private MiddleGame middleGame1;
    private DrawFour drawFour1 = new DrawFour();
    private DrawTwo drawTwo1 = new DrawTwo(Colors.RED);
    private NumberCards unoRed = new NumberCards(Colors.RED, 1);
    
    
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
        drawFour1.effect(middleGame1);
        int nextSize = previousSize + 4;
        assertEquals(nextSize, middleGame1.getPlayer(middleGame1.getNextPlayer()).getHand().size());
    }
    
    @Test 
    public void testSetColor() {
        drawFour1.setColor(Colors.RED);
        assertEquals(Colors.RED, drawFour1.getColor());
    }
    
    @Test 
    public void testGetColor() {
        assertEquals(null, drawFour1.getColor());
    }
    
    @Test 
    public void testValueToString() {
        assertEquals("DRAWFOUR", drawFour1.valueToString());
    }
    
    @Test 
    public void testColorToString() {
        drawFour1.setColor(Colors.RED);
        assertEquals("RED", drawFour1.colorToString());
    }
    
    @Test 
    public void testColorToString1() {
        assertEquals("", drawFour1.colorToString());
    }
    
    @Test
    public void testCanThrowAgainstSpecial() {
        drawFour1.setColor(Colors.RED);
        assertTrue(drawFour1.canThrowAgainstSpecial(drawTwo1));
    }
    
    @Test
    public void testCanThrowAgainstSpecial1() {
        drawFour1.setColor(Colors.BLUE);
        assertFalse(drawFour1.canThrowAgainstSpecial(drawTwo1));
    }
    
    @Test
    public void canThrowAgainstNumber() {
        drawFour1.setColor(Colors.RED);
        assertTrue(drawFour1.canThrowAgainstNumber(unoRed));
    }
    
    @Test
    public void canThrowAgainstNumber1() {
        drawFour1.setColor(Colors.YELLOW);
        assertFalse(drawFour1.canThrowAgainstNumber(unoRed));
    }
    
    @Test
    public void testCanBeFirst() {
        assertFalse(drawFour1.canBeFirst());
    }
    
    @Test
    public void testClearColor() {
        drawFour1.clearColor();
        assertEquals(null, drawFour1.getColor());
    }
    
    @Test 
    public void testGetState() {
        assertEquals(States.SPECIAL, drawFour1.getState());
    }
    
    @Test
    public void testcanThrow() {
        assertTrue(drawFour1.canThrow(unoRed));
    }
    
    @Test
    public void testGetPoints() {
        assertEquals(50, drawFour1.getPoints());
    }
}
