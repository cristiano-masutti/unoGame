package tui;

import model.Messages;
import model.MiddleGame;


/**
 * Used to draw a card.
 *
 * @author masutc@usi.ch fontani@usi.ch.
 * @version 13/05/2022
*/
 
public class DrawCard extends Actions
{
    /**
     * The constructor.
     */
    public DrawCard() {
        super("draw a card");
    }
    
    /**
     * Requirements for that method.
     * @return requirements for that method
     */
    @Override
    public String requirements() {
        return "nothing";
    }
    
    /**
     * Makes player draw a card.
     * @return result the result of operation.
     */
    @Override 
    public Messages execute(String[] input, MiddleGame middleGame) {
        return middleGame.playerDraw();
    }
}