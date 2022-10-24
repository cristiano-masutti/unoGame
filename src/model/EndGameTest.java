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
public class EndGameTest
{
    private EndGame endGame1 = new EndGame();
    
    @Test 
    public void testGetFinalRank() {
        Player[] players = new Player[2];
        for (int i = 0; i < 2; i++) {
            players[i] = new Player(String.valueOf(i));
            players[i].draw(new NumberCards(Colors.BLUE, 10-i));
        }
        endGame1.setPlayers(players);
        players = endGame1.getFinalRank();
        assertEquals("0", players[0].getName());        
    }
}
