package model;

/**
 * Black card can be either a Wild card or plus fout (also ClearHand card in special modes).
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
//         subclass      superclass
public abstract class BlackCard extends PlayableCards {
    private Special value;
    private Colors colorOnTable;

    /** 
     * BlackCard constructor.
     * @param value for keeping the count of the score
     */
    public BlackCard(Special value) {
        super(50);
        this.value = value;
        colorOnTable = null;
    }

    /** 
     * set color of the card.
     * @param color of the card
     */
    @Override
    public void setColor(Colors color) {
        colorOnTable = color;
    }

    @Override 
    public String valueToString() {
        return value.toString();
    }

    @Override
    public String colorToString() {
        if (colorOnTable == null) {
            return "";
        }
        return colorOnTable.toString();
    }

    /**
     * Get color of the card.
     */
    @Override 
    public Colors getColor() {
        return colorOnTable;
    }

    /**
     * Checks if a special card can be thrown against that.
     * @param card the card to be thrown
     * @return if a card can be thrown
     */
    @Override
    public boolean canThrowAgainstSpecial(SpecialCards card) {
        return colorOnTable == card.getColor();
    }

    /**
     * Checks if a numbered card can be thrown against that.
     * @param card the card to be thrown
     * @return if a card can be thrown
     */
    @Override
    public boolean canThrowAgainstNumber(NumberCards card) {
        return colorOnTable == card.getColor();
    }

    /**
     * Sets if a card can be the first of the match in discarded deck.
     * @return if can be the first
     */
    @Override 
    public boolean canBeFirst() {
        return false;
    }

    /**
     * Reset color of the card.
     */
    @Override
    public void clearColor() {
        colorOnTable = null;
    }
}