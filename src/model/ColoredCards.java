package model;

/**
 * ColoredCards are all numered cards.
 *
 *@author masutc@usi.ch fontani@usi.ch.
 * @version 26/05/2002
 */
public abstract class ColoredCards extends PlayableCards
{
    private final Colors color;
    
    /**
     * constructor of ColoredCards.
     * @param points are the points the player gets when the game is finished
     * @param color is color of the card
     */
    public ColoredCards(int points, Colors color) {
        super(points);
        this.color = color;
    }

    /** 
     * get the color of the card.
     *  @return Colors
     */
    public Colors getColor() {
        return color;
    }

    @Override
    public String colorToString() {
        return color.toString();
    }

    /** 
     * return the color of the card.
     * @param card that gets compared to
     * @return boolean
     */
    public boolean compareColor(ColoredCards card) {
        return this.color == card.color;
    }

    /** 
     * canThrowAgainstBlack check if a card can be thrown on top a black card after color is selected.
     * @param card is the black cards that gets compared
     * @return boolean
     */
    public boolean canThrowAgainstBlack(BlackCard card) {
        return this.color == card.getColor();
    }
}