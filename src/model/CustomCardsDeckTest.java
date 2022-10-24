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
public class CustomCardsDeckTest
{
    private NumberCards unoRed = new NumberCards(Colors.RED, 1);
    private CustomCardsDeck customCardsDeck1 = new CustomCardsDeck();
    // fix
    @Test
    public void testAddCard()
    {
        int sizeBefore = customCardsDeck1.getDeckSize();
        customCardsDeck1.addCard(unoRed);
        int sizeAfter = customCardsDeck1.getDeckSize();
        assertEquals(sizeBefore + 1, sizeAfter);
    }
    
    @Test
    public void testTakeDeck()
    {
        customCardsDeck1.addCard(unoRed);
        customCardsDeck1.addCard(unoRed);
        customCardsDeck1.addCard(unoRed);
        CustomCardsDeck customCardsDeck2 = new CustomCardsDeck();
        int sizeDeck2 = customCardsDeck2.getDeckSize();
        customCardsDeck1.takeDeck(customCardsDeck2.getDeck());
        assertEquals(sizeDeck2, customCardsDeck1.getDeckSize());
    }

    // fix
    @Test
    public void testgetLastCardTest()
    {
        int sizeDeck1 = customCardsDeck1.getDeckSize();
        customCardsDeck1.shuffleDeck();
        assertEquals(sizeDeck1, customCardsDeck1.getDeckSize());
    }
    
    @Test
    public void testGetCard() {
        int sizeDeck1 = customCardsDeck1.getDeckSize();
        PlayableCards card = customCardsDeck1.getCard();
        assertEquals(sizeDeck1-1, customCardsDeck1.getDeckSize());
    }
}