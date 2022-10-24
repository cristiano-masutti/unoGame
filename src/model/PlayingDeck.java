package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Methods for all decks used to draw.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public abstract class PlayingDeck extends Deck
{
    /** drawCard will draw a card from the deck.
     * @return last card thrown, type Card
     */
    @Override
    public PlayableCards getCard() {
        return deck.remove(0);   
    }

    /** shuffles the deck.
     * @param deck the deck it needs to shuffle
     */
    public void takeDeck(ArrayList<PlayableCards> deck) {
        this.deck = deck;
        shuffleDeck();
    }

    /** shuffles the deck.
     */
    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    @Override
    public  void addCard(PlayableCards element) {
        deck.add(element);
    }
    
    /**
     * setNumberCards creates the numbered cards.
     * @param color of the card
     */
    public void setNumberCards(Colors color) {
        for (int i = 0; i < 10; i++) {
            deck.add(new NumberCards(color, i));
        }
    }
    
    /**
     * setSpecialCards creates special cards.
     * @param color of the card
     */
    public void setSpecialCards(Colors color) {
        deck.add(new Skip(color));
        deck.add(new DrawTwo(color));
        deck.add(new Reverse(color));
    }
    
    /**
     * setBlackCards creates black cards.
     */
    public void setBlackCards() {
        for (int i = 0; i < 4; i++ ) {
            deck.add(new DrawFour());
            deck.add(new Wild());
        }
    }
}
