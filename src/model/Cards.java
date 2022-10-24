package model;

/**
 * Abstract methods of all cards, every card has a number.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public interface Cards
{
    /** The effect of the card.
     * @param middleGame the game
     */
    public abstract void effect(MiddleGame middleGame);

    /** Checks if card can be thrown on a special card.
     * @param card the special card
     * @return if can throw against special
     */
    public abstract boolean canThrowAgainstSpecial(SpecialCards card);

    /** Checks if card can be thrown on a Number card.
     * @param card the numbered card
     * @return if can throw against number
     */
    public abstract boolean canThrowAgainstNumber(NumberCards card);

    /** Looks if a card can be thrown.
     * @param card a card
     * @return  if card can be thrown
     */
    public abstract boolean canThrow(PlayableCards card);

    /** Return value of card in String.
     * @return the value in String
     */
    public abstract String valueToString();

    /** Return color of card in String.
     * @return the value in String
     */
    public abstract String colorToString();

    /** Return color of card.
     * @return the value in String
     */
    public abstract Colors getColor();

    /** Return points of a card.
     * @return the value in String
     */
    public abstract int getPoints();

    /**
     * clears the color before a black card is thrown.
     */
    public abstract void clearColor();

    /**
     * set the color before a black card is thrown.
     * @param color of the wished color
     */
    public abstract void setColor(Colors color);
}