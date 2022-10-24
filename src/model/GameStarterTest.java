package model;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class GameStarterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class GameStarterTest
{
    private GameStarter gameStarterDefaultDeck = new GameStarter();
    private GameStarter gameStarterSpecialCards = new GameStarter();
    private GameStarter gameStarterCustomCards = new GameStarter();
    
    @Test
    public void testNewDeckNormalCards() {
        gameStarterDefaultDeck.selectDeck(1);
        assertEquals(111, gameStarterDefaultDeck.getPlayingDeck().size());
        assertEquals(111, gameStarterDefaultDeck.getPlayingDeckSize());
        assertEquals(1, gameStarterDefaultDeck.getDiscardedDeck().size());
        assertEquals(1, gameStarterDefaultDeck.getDiscardedDeckSize());
    }
    
    @Test
    public void testNewDeckSpecialCards() {
        gameStarterSpecialCards.selectDeck(2);
        assertEquals(131, gameStarterSpecialCards.getPlayingDeck().size());
        assertEquals(131, gameStarterSpecialCards.getPlayingDeckSize());
        assertEquals(1, gameStarterSpecialCards.getDiscardedDeck().size());
        assertEquals(1, gameStarterSpecialCards.getDiscardedDeckSize());
    }
    
    @Test
    public void testNewDeckCustomCards() {
        gameStarterCustomCards.selectDeck(3);
        assertEquals(183, gameStarterCustomCards.getPlayingDeck().size());
        assertEquals(183, gameStarterCustomCards.getPlayingDeckSize());
        assertEquals(1, gameStarterCustomCards.getDiscardedDeck().size());
        assertEquals(1, gameStarterCustomCards.getDiscardedDeckSize());
    }
    
    @Test
    public void testDrawCard() {
        gameStarterDefaultDeck.selectDeck(1);
        ArrayList<PlayableCards> cards = new ArrayList<PlayableCards>();
        cards.add(gameStarterDefaultDeck.getLastCard());
        assertEquals(1, cards.size());
    }
    
    @Test
    public void testWrongDeck() {
        assertEquals(gameStarterDefaultDeck.selectDeck(4), Messages.INVALIDARGUMENTS); 
    }
    
    @Test
    public void testWrongPlayers() {
        assertEquals(Messages.INVALIDARGUMENTS, gameStarterDefaultDeck.newPlayers(1)); 
        assertEquals(Messages.INVALIDARGUMENTS, gameStarterDefaultDeck.newPlayers(5)); 
    }
    
    
    @Test
    public void testInitExistingPlayers() {
        GameStarter gameStarter1 = new GameStarter();
        gameStarter1.selectDeck(1);
        gameStarter1.newPlayers(2);
        for (int i = 0; i < 2; i++) {
            gameStarter1.initPlayers("a", i);
        }
        gameStarter1.initialDraw();
        assertEquals(2, gameStarter1.getPlayersNumber());
        gameStarter1.initExistingPlayers();
        assertEquals(2, gameStarter1.getPlayersNumber());
    }
    
    @Test
    public void testInitNewPlayers() {
        GameStarter gameStarter1 = new GameStarter();
        gameStarter1.selectDeck(1);
        gameStarter1.newPlayers(2);
        for (int i = 0; i < 2; i++) {
            gameStarter1.initPlayers("a", i);
        }
        gameStarter1.initialDraw();
        assertEquals(2, gameStarter1.getPlayersNumber());
        assertEquals("a", gameStarter1.getPlayerName(0));
        assertEquals(null, gameStarter1.getPlayerName(-1));
        assertEquals(null, gameStarter1.getPlayerName(10));
        assertEquals(2, gameStarter1.getPlayers().length);
    }
}
