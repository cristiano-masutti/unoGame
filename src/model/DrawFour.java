package model;

/**
 *  Draw four changes color and makes next player draw four cards.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class DrawFour extends BlackCard {
    /**
     * DrawFour's constructor.
     */
    public DrawFour() {
        super(Special.DRAWFOUR);
    }

    @Override
    public States getState() {
        return States.SPECIAL;
    }

    /**
     * draw four cards from the deck.
     * @param middleGame is the game dynamics (model)
     */
    @Override
    public void effect(MiddleGame middleGame) {
        for (int i = 0; i < 4; i++) {
            middleGame.drawCard(middleGame.getNextPlayer());
        }
    }
}
