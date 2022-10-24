package model;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Discarded deck, (the deck in the middle, gui) where players throw the cards.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class Discarded extends Deck
{      
    /** 
    * Add a card in the dicarted pile.
    * @param element the discarded card
    */
    @Override
    public void addCard(PlayableCards element) {
        deck.add(0, element);
    }
    
    /** 
    * Prepares the deck to be shuffled, keeping the cards whose effect is still useful.
    * @param remainingCards the number of still useful cards
    * @return temp the ready deck
    */
    public ArrayList<PlayableCards> prepareShuffle(int remainingCards) {
        ArrayList<PlayableCards> temp = new ArrayList<PlayableCards>();
        temp.addAll(deck);
        deck.clear();
        for (int i = 0; i <= remainingCards; i++) {
            deck.add(temp.get(0));
        }
        return temp;
    }
    
    /** 
    * Returns the last card in the discarded deck.
    * @return last card of deck
    */
    public PlayableCards getCard() {
        return deck.get(0);
    }
    
    /** 
    * Returns the card at some index in the discarded deck.
    * @param index want card's index
    * @return card at that index
    */
    public PlayableCards getCard(int index) {
        return deck.get(index);
    }
    
    /**
     * Swaps cards at index 0 and index.
     * @param index the index of swapping card
     */
    public void swapLastCard(int index) {
        Collections.swap(deck, 0, index);
    }
}
