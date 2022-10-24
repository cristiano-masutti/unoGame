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
public class SpecialCardsDeckTest
{
    private NumberCards unoRed = new NumberCards(Colors.RED, 1);
    private SpecialCardsDeck specialCardsDeck1 = new SpecialCardsDeck();
    // fix
    @Test
    public void testAddCard()
    {
        int sizeBefore = specialCardsDeck1.getDeckSize();
        specialCardsDeck1.addCard(unoRed);
        int sizeAfter = specialCardsDeck1.getDeckSize();
        assertEquals(sizeBefore+1, sizeAfter);
    }
    
    @Test
    public void testTakeDeck()
    {
        specialCardsDeck1.addCard(unoRed);
        specialCardsDeck1.addCard(unoRed);
        specialCardsDeck1.addCard(unoRed);
        CustomCardsDeck customCardsDeck2 = new CustomCardsDeck();
        int sizeDeck2 = customCardsDeck2.getDeckSize();
        specialCardsDeck1.takeDeck(customCardsDeck2.getDeck());
        assertEquals(sizeDeck2, specialCardsDeck1.getDeckSize());
    }

    // fix
    @Test
    public void testgetLastCardTest()
    {
        int sizeDeck1 = specialCardsDeck1.getDeckSize();
        specialCardsDeck1.shuffleDeck();
        assertEquals(sizeDeck1, specialCardsDeck1.getDeckSize());
    }
    
    @Test
    public void testGetCard() {
        int sizeDeck1 = specialCardsDeck1.getDeckSize();
        PlayableCards card = specialCardsDeck1.getCard();
        assertEquals(sizeDeck1-1, specialCardsDeck1.getDeckSize());
    }
}