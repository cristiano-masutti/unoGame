package model;

/**
 * playable cards are colored cards + specials.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022.
 */
public abstract class PlayableCards implements Cards
{
    private int points;
    
    /** 
     * constructor of PlayableCards.
     * @param points ammount of points
     */
    public PlayableCards(int points) {
        this.points = points;
    }

    /** 
     * return the state of the game.
     * @return States
     */
    public States getState() {
        return States.NORMAL;
    }

    /**
     * canBeFirst check if a card can be placed first on the discarded deck when the game starts.
     * @return boolean true if a card can be first
     */
    public boolean canBeFirst() {
        return true;
    }

    /**
     * canThrow check if a card can be placed on the discaded deck.
     * @return boolean true if can be thrown
     */
    @Override
    public boolean canThrow(PlayableCards card) {
        return true;
    }

    /**
     * getPoints return players' points.
     * @return int ammount of points
     */
    @Override
    public int getPoints() {
        return points;
    }
}
