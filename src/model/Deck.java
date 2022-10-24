package model;

import java.util.ArrayList;

/**
 *  Has all method in common among all decks.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */

public abstract class Deck {
    protected ArrayList<PlayableCards> deck;
    
    /** 
    * Deck constructor.
    */
    public Deck() {
        deck = new ArrayList<PlayableCards>();
    }
    
    /** 
     * bonestructure of getCard.
     * @return PlayableCards
    */
    public abstract PlayableCards getCard();
    
    /**
     * abstract methhod, adds a card.
     * @param element of the card
     */
    public abstract void addCard(PlayableCards element);

    /** 
     * Get deck size.
     * @return int the size of the deck
    */
    public int getDeckSize() {
        return this.deck.size();
    }
    
    /** 
     * Get the deck.
     * @return the deck
    */
    public ArrayList<PlayableCards> getDeck() {
        return deck;
    }
}
