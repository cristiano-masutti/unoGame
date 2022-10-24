package model;

/**
 * The special cards.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 23/05/2002
 */
public abstract class SpecialCards extends ColoredCards
{
    private Special value;

    /**
     * The constructor.
     * @param color a color
     * @param value a value
     */
    public SpecialCards(Colors color, Special value) {
        super(20, color);
        this.value = value;
    }

    /** Compare cards value.
     * @param card a card
     * @return a boolean, true if the value is the same to the card's value
     */
    public boolean compareValue(SpecialCards card) {
        return value == card.value;
    }

    /** Compare cards value.
     * @return the string with the value and the color.
     */
    @Override 
    public String valueToString() {
        return value.toString();
    }

    /** Checks if card is throwable.
     * @param card a card
     * @return a boolean, if a card is throwable.
     */
    @Override
    public boolean canThrow(PlayableCards card) {
        return card.canThrowAgainstSpecial(this);
    }

    /** Checks if card is throwable.
     * @param card a card
     * @return a boolean, if a card is throwable.
     */
    @Override
    public boolean canThrowAgainstSpecial(SpecialCards card) {
        return compareValue(card) || compareColor(card);
    }

    /** Checks if card is throwable.
     * @param card a card
     * @return a boolean, if a card is throwable.
     */
    @Override
    public boolean canThrowAgainstNumber(NumberCards card) {
        return compareColor(card);
    }
}
