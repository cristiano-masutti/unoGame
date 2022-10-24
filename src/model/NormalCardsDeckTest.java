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
public class NormalCardsDeckTest
{
    private NumberCards unoRed = new NumberCards(Colors.RED, 1);
    private NormalCardsDeck normalCardsDeck1 = new NormalCardsDeck();
    // fix
    @Test
    public void testAddCard()
    {
        int sizeBefore = normalCardsDeck1.getDeckSize();
        normalCardsDeck1.addCard(unoRed);
        int sizeAfter = normalCardsDeck1.getDeckSize();
        assertEquals(sizeBefore+1, sizeAfter);
    }
    
    @Test
    public void testTakeDeck()
    {
        normalCardsDeck1.addCard(unoRed);
        normalCardsDeck1.addCard(unoRed);
        normalCardsDeck1.addCard(unoRed);
        CustomCardsDeck customCardsDeck2 = new CustomCardsDeck();
        int sizeDeck2 = customCardsDeck2.getDeckSize();
        normalCardsDeck1.takeDeck(customCardsDeck2.getDeck());
        assertEquals(sizeDeck2, normalCardsDeck1.getDeckSize());
    }

    // fix
    @Test
    public void testgetLastCardTest()
    {
        int sizeDeck1 = normalCardsDeck1.getDeckSize();
        normalCardsDeck1.shuffleDeck();
        assertEquals(sizeDeck1, normalCardsDeck1.getDeckSize());
    }
    
    @Test
    public void testGetCard() {
        int sizeDeck1 = normalCardsDeck1.getDeckSize();
        PlayableCards card = normalCardsDeck1.getCard();
        assertEquals(sizeDeck1-1, normalCardsDeck1.getDeckSize());
    }
}