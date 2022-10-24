package model;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * The test class GameStarterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PlayerTest
{
    private Player player1 = new Player("a");
    private PlayableCards unoCard = new NumberCards(Colors.RED, 1);
    
    @Test 
    public void testCards() {
        player1.draw(unoCard);
        assertEquals(unoCard, player1.getCard(0));
    }
    
    @Test
    public void testUnoCall() {
        assertFalse(player1.isUnoCalled());
        player1.unoCall();
        assertTrue(player1.isUnoCalled());
    }
    
    @Test
    public void testHasPlayable() {
        player1.draw(unoCard);
        assertTrue(player1.hasPlayable(new NumberCards(Colors.RED, 1)));
        assertFalse(player1.hasPlayable(new NumberCards(Colors.BLUE, 4)));
    }
    
    @Test
    public void testHasSpecialPlayable() {
        player1.draw(unoCard);
        player1.draw(new DrawTwo(Colors.RED));
        assertTrue(player1.hasSpecialPlayable(new DrawTwo(Colors.RED)));
        assertFalse(player1.hasSpecialPlayable(new NumberCards(Colors.BLUE, 4)));
    }
}
