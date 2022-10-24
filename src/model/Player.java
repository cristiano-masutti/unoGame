package model;

import java.util.ArrayList;

/**
 * Players possible actions.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
 */
public class Player
{
    private final String name;
    private ArrayList<PlayableCards> hand;
    private boolean uno;
    private int points;

    /** 
     * Player constructor.
     * @param name of the player
     */
    public Player(String name) {
        this.name = name;
        hand = new ArrayList<PlayableCards>();
        uno = false;
        points = 0;
    }

    /**
     * getCard returns card (PlayableCards).
     *  @param index of player
     *  @return PlayableCards the PlayableCards
     */
    public PlayableCards getCard(int index) {
        return hand.get(index);
    }

    /** 
     * draw a card and stores it in hand.
     * @param card the card the player is drawing
     */
    public void draw(PlayableCards card) {
        hand.add(card);
    }

    /** 
     *  Throw the card.
     *  @param selectedCard int of the selected card
     *  @return PlayableCards
     */
    public PlayableCards toThrow(int selectedCard) {
        uno = false;
        return hand.remove(selectedCard);
    }

    /** 
     * At the last card the player must call this function.
     */
    public void unoCall() {
        uno = true;
    }

    /** 
     * Check Uno status. 
     * @return true if uno is called
     */
    public boolean isUnoCalled() {
        return uno;
    }

    /** 
     * Return the number of cards the player still have.
     * @return int number of cards
     */
    public int getHandSize() {
        return hand.size();
    }

    /** prints name's player and the hand.
     * @return ArrayList of PlayableCards
     */
    public ArrayList<PlayableCards> getHand() {
        ArrayList<PlayableCards> tmp = hand;
        return tmp;
    }

    /** 
     * Return the name of the player.
     * @return String name
     */
    public String getName() {
        return name;
    }

    /** 
     * Return the number of points.
     * @return int points
     */
    public int getPoints() {
        return points;
    }

    /** 
     * clears the hand of the player.
     */
    public void resetHand() {
        this.hand.clear();
    }

    /** 
     * counts the points after a match.
     */
    public void countPoints() {
        for (int i = 0; i < getHandSize(); i++) {
            this.points += points;
        }
    }

    /** 
     * return if card can be played.
     * @param lastCard the last card
     * @param index of the card
     * @return boolean true if card can be played
     */
    public boolean canPlay(PlayableCards lastCard, int index) {
        return hand.get(index).canThrow(lastCard);
    }

    /** 
     * hasPlayable return if players has a playable card.
     * @param lastCard the last card
     * @return boolean true if player has a playable card
     */
    public boolean hasPlayable(PlayableCards lastCard) {
        for (int i = 0; i < hand.size(); i++) {
            if (canPlay(lastCard, i)) {
                return true;
            }
        }
        return false;
    }

    /** 
     * hasSpecial return if players has a special card.
     * @param lastCard the last card
     * @return boolean true if player has a playable card
     */
    public boolean hasSpecialPlayable(PlayableCards lastCard) {
        for (PlayableCards card : hand) {
            if (card.getState() == States.SPECIAL && card.canThrow(lastCard)) {
                return true;
            }
        }
        return false;
    }
}
