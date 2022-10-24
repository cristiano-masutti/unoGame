package model;

import java.util.ArrayList;

/**
 * Dynamics of the decks.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 20/05/2022
 */
public class Playing extends Table
{
    protected Discarded discardedDeck;
    protected PlayingDeck playingDeck;

    /**
     * generates the selected deck.
     * @return ArrayList PlayableCards the playable cards
     */
    public ArrayList<PlayableCards> getPlayingDeck() {
        ArrayList<PlayableCards> tmp = playingDeck.getDeck();
        return tmp;
    }

    /**
     * getPlayingDeckSize return how many card(s) has the playing deck.
     * @return int size of the playing decks
     */
    public int getPlayingDeckSize() {
        return playingDeck.getDeck().size();
    }

    /**
     * getDiscardedDeck will return the discarded deck before shuffling.
     * @return ArrayList PlayableCards an arrayList of card
     */
    public ArrayList<PlayableCards> getDiscardedDeck() {
        ArrayList<PlayableCards> tmp = discardedDeck.getDeck();
        return tmp;
    }

    /**
     * getDiscardedDeck returns the size of the discarded deck.
     * @return int discarded deck' size
     */
    public int getDiscardedDeckSize() {
        return discardedDeck.getDeck().size();
    }

    /** 
     *  getLastCard return last card.
     *  @return PlayableCards
     */
    public PlayableCards getLastCard() {
        return discardedDeck.getCard();
    }

    /**
     * return discarded deck.
     * @return Discarded  the discarded deck
     */
    public Discarded getDiscarded() {
        return discardedDeck;
    }

    /**
     * return the playing decks.
     * @return PlayingDeck
     */
    public PlayingDeck getPlaying() {
        return playingDeck;
    }
}

