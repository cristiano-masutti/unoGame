package model;

/**
 * Draw two is a card that from the deck.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class DrawTwo extends SpecialCards
{   
    /**
     * The constructor of DrawTwo.
     * @param color a color
     */
    public DrawTwo(Colors color) {
        super(color, Special.DRAWTWO);
    }

    /** Apply effect.
     * @param game are the game dynamics
     */
    @Override
    public void effect(MiddleGame game) {
        for (int i = 0; i < 2; i++) {
            game.drawCard(game.getNextPlayer());
        }
    }

    @Override
    public States getState() {
        return States.SPECIAL;
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
