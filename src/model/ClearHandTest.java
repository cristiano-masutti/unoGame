package model;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClearHandTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClearHandTest
{
    private ClearHand clearHand = new ClearHand();
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
        clearHand.effect(middleGame1);
        assertEquals(previousSize, middleGame1.getPlayerHand().size());
    }
}
