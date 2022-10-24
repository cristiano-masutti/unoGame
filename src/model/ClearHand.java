package model;


/**
 *  Draw four changes color and makes next player draw four cards.
 *
 * @author masutc@usi.ch fontani@usi.ch
 * @version 13/05/2002
 */
public class ClearHand extends BlackCard
{
    /** constructor of ClearHand.
     */
    public ClearHand() {
        super(Special.CLEARHAND);
    }
    
    /** clear hand of the player that throws the card.
     *  @param middleGame the game is currently going (gui)
     */
    @Override
    public void effect(MiddleGame middleGame) {
        middleGame.clearHand();
    }
}
