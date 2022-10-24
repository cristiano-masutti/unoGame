package model;

/**
 * Class NumberCard represents all the numbered cards.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022 
 */
//           subclass             superclass
public class NumberCards extends ColoredCards
{
    private int value;

    /**
     * NumberCards constructor.
     * @param color of the card
     * @param value of the card
     */
    public NumberCards(Colors color, int value) {
        super(value, color);
        this.value = value;
    }

    /** 
     * returns the value of the card.
     * @return String
     */
    @Override
    public String valueToString() {
        return Integer.toString(value);
    }

    /** 
     * returns true if you can throw the card.
     * @param card a Card
     * @return boolean
     */
    @Override
    public boolean canThrow(PlayableCards card) {
        return card.canThrowAgainstNumber(this);
    }

    /** 
     * returns true if you can throw on top of a special card.
     * @param card a SpecialCard
     * @return boolean
     */
    @Override
    public boolean canThrowAgainstSpecial(SpecialCards card) {
        return compareColor(card);
    }

    /** 
     * Check if can be thrown againts a numbered card.
     * @param card NumberCard
     * @return boolean, returns true if you can throw on top of a number
     */
    @Override
    public boolean canThrowAgainstNumber(NumberCards card) {
        return value == card.value || compareColor(card);
    }

    /** 
     * effect of card.
     * @param game the game
     */
    @Override
    public void effect(MiddleGame game) {
        //no effect
    }

    @Override
    public void setColor(Colors color) {
        //no effect
    }

    @Override
    public void clearColor() {
        //no effect
    }
}
