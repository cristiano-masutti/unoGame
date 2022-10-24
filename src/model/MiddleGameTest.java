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
public class MiddleGameTest
{
    private MiddleGame middleGame1;
    private GameStarter gameStarter1;
    private NumberCards blueOne = new NumberCards(Colors.BLUE, 1);
    private NumberCards redOne = new NumberCards(Colors.RED, 1);
    private NumberCards redFour = new NumberCards(Colors.RED, 4);
    private DrawTwo drawTwo1 = new DrawTwo(Colors.RED);
    private Wild wild1 = new Wild();
    
    
    @Test
    public void initMiddleGame()  {
        gameStarter1 = new GameStarter();
        gameStarter1.selectDeck(1);
        gameStarter1.newPlayers(4);
        for (int i = 0; i < 4; i++) {
            gameStarter1.initPlayers(String.valueOf(i), i);
        }
    }
    
    public void initPlayerHand() {
        initMiddleGame();
        gameStarter1.initialDraw();
        middleGame1 = gameStarter1.startGame();
    }
    
    public void noCardsInHand() {
        initMiddleGame();
        middleGame1 = new MiddleGame(gameStarter1.getPlaying(), gameStarter1.getDiscarded());
        middleGame1.setPlayers(gameStarter1.getPlayers());
    }
    
    @Test
    public void testGetEnd() {
        initPlayerHand();
        assertEquals("0", middleGame1.getEnd().getPlayerName(0));
    }
    
    @Test
    public void testReverseSense() {
        initPlayerHand();
        assertEquals("1", middleGame1.getPlayerName(middleGame1.getNextPlayer()));
        assertTrue(middleGame1.isSenseNormal());
        middleGame1.reverseSense();
        assertEquals("3", middleGame1.getPlayerName(middleGame1.getNextPlayer())); 
        assertFalse(middleGame1.isSenseNormal());
        middleGame1.reverseSense();
        assertTrue(middleGame1.isSenseNormal());
    }
    
    @Test
    public void testSwapDeck() {
        initPlayerHand();
        for (int i = 0; i < 120; i++) {
            middleGame1.drawCard(0);
        }
        assertEquals(States.NORMAL, middleGame1.getState());
    }
    
    @Test
    public void testCheckEnd() {
        noCardsInHand();
        assertEquals(Messages.TERMINATED, middleGame1.checkEnd(null));
    }
    
    @Test
    public void testCheckEnd1() {
        initPlayerHand();
        assertEquals(Messages.SUCCESS, middleGame1.checkEnd(Messages.SUCCESS));
    }
    
    @Test
    public void testSetState() {
        initPlayerHand();
        assertEquals(States.NORMAL, middleGame1.getState());
        middleGame1.setState(States.SPECIAL);
        assertEquals(States.SPECIAL, middleGame1.getState());
    }
    
    @Test
    public void testUnoCall() {
        initPlayerHand();
        middleGame1.unoCall();
        assertTrue(middleGame1.getPlayer(0).isUnoCalled());
    }
    
    
    @Test 
    public void testThrower() {
        noCardsInHand();
        DrawTwo drawTwo1 = new DrawTwo(Colors.BLUE);
        middleGame1.thrower(drawTwo1);
        assertEquals(States.SPECIAL, middleGame1.getState());
        assertEquals(drawTwo1, middleGame1.getLastCard());
    }
    
    @Test 
    public void testThrower1() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        assertEquals(States.NORMAL, middleGame1.getState());
        assertEquals(blueOne, middleGame1.getLastCard());
    }
    
    @Test
    public void testThrowColored() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        middleGame1.getPlayer(0).draw(blueOne);
        middleGame1.getPlayer(0).draw(blueOne);
        middleGame1.getPlayer(0).draw(wild1);
        assertEquals(Messages.INVALIDCARD, middleGame1.throwColoredCard(8)); 
        assertEquals(Messages.INVALIDCARD, middleGame1.throwColoredCard(-1)); 
        assertEquals(Messages.INVALIDCARD, middleGame1.throwColoredCard(2));
        assertEquals(Messages.SUCCESS, middleGame1.throwColoredCard(0));   
        assertEquals(Messages.ALREADYTHROWN, middleGame1.throwColoredCard(0));        
    }
    
    
    @Test
    public void testThrowColored1() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        middleGame1.getPlayer(0).draw(blueOne);
        middleGame1.getPlayer(0).draw(redFour);     
        assertEquals(Messages.INVALIDCARD, middleGame1.throwColoredCard(1));   
    }
    
    @Test
    public void testThrowBlackCard() {
        noCardsInHand();
        middleGame1.getPlayer(0).draw(wild1);
        assertEquals(Messages.SUCCESS, middleGame1.throwBlackCard(0, Colors.RED));
    }
    
    @Test
    public void testPlayerDraw() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        middleGame1.getPlayer(0).draw(redFour);
        assertEquals(Messages.SUCCESS, middleGame1.playerDraw());
    }
    
    @Test
    public void testPlayerDraw1() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        middleGame1.getPlayer(0).draw(blueOne);
        assertEquals(Messages.CANTHROW, middleGame1.playerDraw());
    }
    
    @Test
    public void testPlayerDraw2() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        middleGame1.getPlayer(0).draw(blueOne);
        middleGame1.throwColoredCard(0);
        assertEquals(Messages.ALREADYTHROWN, middleGame1.playerDraw());
    }
    
    @Test
    public void testEndTurn() {
        noCardsInHand();
        middleGame1.thrower(blueOne);
        middleGame1.endTurn();
        assertEquals(middleGame1.getState(), States.NORMAL);
    }
    
    @Test
    public void testEndTurnSpecial() {
        noCardsInHand();
        middleGame1.thrower(drawTwo1);
        middleGame1.endTurn();
        assertEquals(States.SPECIAL, middleGame1.getState());
    }
    
    @Test
    public void testEndSpecial() {
        noCardsInHand();
        middleGame1.getPlayer(1).draw(drawTwo1);
        middleGame1.thrower(drawTwo1);
        middleGame1.endTurn();
        assertEquals(1, middleGame1.getPlayer(1).getHandSize());
    }
    
    @Test
    public void testCheckContinuation() {
        noCardsInHand();
        middleGame1.thrower(drawTwo1);
        middleGame1.getPlayer(1).draw(drawTwo1);
        middleGame1.getPlayer(1).draw(redOne);
        middleGame1.endTurn();       
        middleGame1.throwColoredCard(1);
        assertEquals(3, middleGame1.getPlayer(1).getHandSize());
    }
    
    @Test
    public void testCheckContinuation1() {
        noCardsInHand();
        middleGame1.thrower(drawTwo1);
        middleGame1.getPlayer(1).draw(drawTwo1);
        middleGame1.getPlayer(1).draw(redOne);
        middleGame1.endTurn();       
        middleGame1.throwColoredCard(0);
        assertEquals(1, middleGame1.getPlayer(1).getHandSize());
    }
    
    @Test
    public void testCheckUno() {
        noCardsInHand();
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.checkHand();
        assertEquals(1, middleGame1.getPlayer(0).getHandSize());
    }
    
    @Test
    public void testCheckUno1() {
        noCardsInHand();
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.thrower(redOne);
        middleGame1.throwColoredCard(0);
        middleGame1.checkHand();
        assertEquals(3, middleGame1.getPlayer(0).getHandSize());
    }
    
    @Test
    public void testCheckUno2() {
        noCardsInHand();
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.thrower(redOne);
        middleGame1.throwColoredCard(0);
        middleGame1.unoCall();
        middleGame1.checkHand();
        assertEquals(1, middleGame1.getPlayer(0).getHandSize());
    }
    
    @Test
    public void testCheckUno3() {
        noCardsInHand();
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.getPlayer(0).draw(redOne);
        middleGame1.thrower(redOne);
        middleGame1.throwColoredCard(0);
        middleGame1.unoCall();
        middleGame1.checkHand();
        assertEquals(2, middleGame1.getPlayer(0).getHandSize());
    }
}
