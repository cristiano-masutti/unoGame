package model;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DiscardedTest.
 *
 * @author  (your name)
 * @version (a version number or a date)*/
public class DiscardedTest
{
    private NumberCards unoRed = new NumberCards(Colors.RED, 1);
    private Discarded discardedDeck1 = new Discarded();
    // fix
    @Test
    public void testAddCard()
    {
        discardedDeck1.addCard(unoRed);
        assertEquals(unoRed, discardedDeck1.getCard());
    }
    
    @Test
    public void testPrepareShuffle()
    {
        discardedDeck1.addCard(unoRed);
        discardedDeck1.addCard(unoRed);
        discardedDeck1.addCard(unoRed);
        discardedDeck1.prepareShuffle(1);
        assertEquals(2, discardedDeck1.getDeckSize());
    }

    // fix
    @Test
    public void testgetLastCardTest()
    {
        model.Discarded discarde1 = new model.Discarded();
    }
    
    @Test
    public void testGetCard() {
        NumberCards twoYellow = new NumberCards(Colors.YELLOW, 2);
        NumberCards threeBLUE = new NumberCards(Colors.BLUE, 3);
        discardedDeck1.addCard(unoRed);
        discardedDeck1.addCard(twoYellow);
        discardedDeck1.addCard(threeBLUE);
        assertEquals(unoRed, discardedDeck1.getCard(2));
    }
}